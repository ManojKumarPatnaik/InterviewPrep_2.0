/*
https://leetcode.com/problems/total-hamming-distance/
Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

efficient solution: good read here https://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/

here we are finding for each bit, how many numbers are set and how many numbers are not set.
 */
class Google_TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {

        int answer = 0;
        for (int bit = 0; bit < 32; bit++) {

            int tempNumber = 1 << bit;
            int isBitSetCount = 0;
            for (int j = 0; j < nums.length; j++) {

                if ((nums[j] & tempNumber) != 0) {
                    isBitSetCount++;
                }

            }

            answer += isBitSetCount * (nums.length - isBitSetCount);
        }

        return answer;
    }
}


//not efficient solution
//O(N2)
/*

class Solution {
    public int totalHammingDistance(int[] nums) {

        int totalDistance = 0;
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j< nums.length; j++) {

                int num1 = nums[i];
                int num2 = nums[j];
                int hammingDistance = getHammingDistance(num1, num2);
                totalDistance+= hammingDistance;

            }
        }

        return totalDistance;
    }

    private int getHammingDistance(int num1, int num2) {

        int distance = 0;

        int xorValue = num1 ^ num2; //xor

        while(xorValue != 0) {

            xorValue = xorValue & (xorValue-1);
            distance++;
        }

        return distance;
    }
}



 */