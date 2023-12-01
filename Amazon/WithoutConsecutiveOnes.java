package Amazon;

//https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
/*
explanation:

when
n=0 -> assume 1
n=1 ->  only two values possible i.e  0 and 1 : means 2 intergers without consecutive ones, similarly when
n=2 ->  00,01,10,11  -> 3
n=3 -> 000,001.....110,111  -> 5

so if we notice, its a fibonacci series 1,2,3,5,8..

but in question we can get any no. let say 10 i.e 1010

1.
0000
0001
0010
0011
0100
0101
0110
0111
1000
1001
1010 = 10
1011  -- from this and its below  values we don't want to consider in our output because its greater than 10
1100
1101
1110
1111

2. '1'010, first most significant bit is 1, means we can cover all number below this.
    - so first part is, if most significant bit is 0, then remaining is equivalent to n=3 (fibonnaci once, which we saw at top)
    0 000
    0 001
    0 010
    0 011
    0 100
    0 101
    0 110
    0 111
    - now there are still some number left smaller than 1010, so we go to the next 1 i.e 10 '1' 0, and the above thing we need
    to do again, means we can cover all number below this.
        - so first part is if its 0
        100 0
        100 1

    - and at last, if we reach till end, means we need to add +1 for the number itself.
    - and if we found 2 consecutive ones, we can break it and return.

1010



 */


public class WithoutConsecutiveOnes {

    private static int findIntegers(int n) {

        String nBinaryRep = Integer.toBinaryString(n);
        int[] arr = new int[nBinaryRep.length()+1];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        char[] nArray = nBinaryRep.toCharArray();
        int output = 0;
        int i=0;
        for(; i<nArray.length; i++) {

            if(nArray[i] == '0') {
                continue;
            } else{

                output+=arr[nArray.length-(i+1)];

                if(i>0 && nArray[i-1] == '1') {
                    break;
                }

            }
        }

        if(i==nArray.length) {
            output+=1;
        }

        return output;

    }

    public static void main(String args[]) {

        int i = 3;
        System.out.println(findIntegers(i));
    }

}


