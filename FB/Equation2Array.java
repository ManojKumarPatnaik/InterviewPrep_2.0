package FB;

//https://leetcode.com/discuss/interview-question/1719834/Meta-coding-question-2022
//https://www.geeksforgeeks.org/count-pairs-i-j-from-arrays-arr-brr-such-that-arri-brrj-arrj-brri/



/*
Yes, this problem can be solved in O(N) time complexity and O(N) space complexity.
The equation a[i] - b[j] = a[j] - b[i]
turns out to be => a[i]+b[i] = a[j]+b[j] ,
thats means we just need to find index j such that a[j]+b[j] has already occured,

this can be done using a unordered_map having frequency for any sum of a[i]+b[i].

imp: final, if any C[I] frequency is more than 1 let say 4, then total combination would be n*(n-1)/2

 */

import java.util.HashMap;
import java.util.Map;

class Equation2Array{

    static void CountPairs(int a[], int b[], int n)
    {
        int tempArray[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            tempArray[i] = a[i] + b[i];
        }
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if (!freqCount.containsKey(tempArray[i]))
                freqCount.put(tempArray[i], 1);
            else
                freqCount.put(tempArray[i],
                        freqCount.get(tempArray[i]) + 1);
        }
        int NoOfPairs = 0;
        for(Map.Entry<Integer,
                Integer> frequency : freqCount.entrySet())
        {
            int freqValue = frequency.getValue();
            NoOfPairs = NoOfPairs +
                    (  freqValue + freqValue * (freqValue - 1) / 2);
        }
        System.out.println(NoOfPairs);
    }

    // Driver Code
    public static void main(String args[])
    {

        // Given array arr[] and brr[]
        int arr[] = { 2, -2, 5, 3 };
        int brr[] = { 1, 5, -1, 1 };

        // Size of given array
        int N = arr.length;

        // Function calling
        CountPairs(arr, brr, N);
    }
}