package Amazon;

public class FindPeak {

    /*

Given a list of integer, the order of the elements will increase then decrease. Find the peak.
example
[1, 3, 6, 4, 2, 0]
output: 6

can we have negative : yes
size of the array :  big
dupliate : yes
[1,3,3,6,6,4,2,0]

only increasing no decreasing
[136] : valid usecase

[4,2,0]: valid

[3,3] : return 3

[] return -1;

[increasing, decreasing]

[1, 3,,6,6,6,6,2,2,2,2,0] = one time iterate and as soon as decreasing value find, return the previous one, if no element at end
[1,3,6]
[4,2,0]
[]
[3,3]

Brute force:
0(N)

Can we Improve:
Time complexity: logn(n) or O(1)


Log(N) : tweak of binary search

    - find the mid
    - if mid is > then left and right value, return this value itself
    - search in right - if right value is >= than the mid value
    - search in left - if left value is bigger than mid
    -
      [3]
    even:    [3,3]
    mid = 0
*/


    private static int findPeakValue(int[] input, int start, int end) {
        if(input.length == 0)
            return -1;

        //take care of start and end length (index out of bond)
        if(start > end)
            return -1;

        //if there is only 1 value, thats the peak itself
        if(input.length == 1)
            return input[start];

        //if there is only 2 value, thats the peak itself
        if(input.length == 2)
            return  input[start] >=input[end]?  input[start] :  input[end];

        //find the mid value
        int midIndex = (start+end)/2;

        if(input[midIndex] > input[midIndex-1] && input[midIndex] > input[midIndex+1])
            return input[midIndex];

        int output = -1;

        //if i know right value is bigger go to right only
        if(input[midIndex] < input[midIndex+1]) {
            output =  findPeakValue(input, midIndex+1, end);
        } else if(input[midIndex] < input[midIndex-1]) {
            //if i know left value is bigger go to left only
            output =   findPeakValue(input, start, midIndex-1);
        } else {
            //this is possible when left and right are equal and peak and be there at any side
            int peakAtRight =  findPeakValue(input, midIndex+1, end);
            int peakAtLeft = findPeakValue(input, start, midIndex-1);

            if(peakAtRight > output) {
                output = peakAtRight;
            }
            if(peakAtLeft >   output) {
                output = peakAtLeft;
            }
        }
        return output;
    }

    public static void main(String args[]) {

        int[] a= {1,2,3,6,6,6,6,6,6,6,9,7,3,2,1};

        System.out.println(findPeakValue(a, 0, a.length));
    }


}
