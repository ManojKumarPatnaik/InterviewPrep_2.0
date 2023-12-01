
/*
https://leetcode.com/problems/minimum-size-subarray-sum/

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/

class MinimumSizeSubarray {
    public static void main(String args[]) {

        int[] nums = {1, 4, 5, 6, 1, 1, 3};
        int target = 7;
        int minSubArrayLen = minSubArrayLen(target, nums);
        System.out.println(minSubArrayLen);
    }


    private static int minSubArrayLen(int target, int[] nums) {

        int windowStart = 0;
        int windowEnd = 0;
        int minSubarraySize = Integer.MAX_VALUE;
        int subArraySum = 0;

        while (windowEnd < nums.length) {

            subArraySum += nums[windowEnd++];
            if (subArraySum >= target) {

                //here we are trying to find the new index of start, just that,
                //even if we remove start, and sum is still >= target, we can increment start
                while (windowStart < windowEnd) {

                    int newSum = subArraySum - nums[windowStart];
                    if (newSum >= target) {
                        subArraySum = newSum;
                        windowStart++;
                    }
                    if (newSum < target) {
                        break;
                    }
                }

                if (minSubarraySize > (windowEnd - windowStart)) {

                    minSubarraySize = (windowEnd - windowStart);
                }

            }

        }
        return minSubarraySize == Integer.MAX_VALUE ? 0 : minSubarraySize;

    }


    //more cleaner coded


/**
 *
 *  public int minSubArrayLen(int target, int[] numbers) {dfd
 *
 *     if(numbers.length == 0 ) return 0;DFD
 *     int count = Integer.MAX_VALUE;
 *     int sum = 0;
 *     int left = 0;
 *
 *     for(int i = 0; i < numbers.length; i++) {
 *
 *         sum += numbers[i];
 *         while(sum >= target) {
 *             //find and update count
 *             count = Math.min(count, i - left + 1);df
 *             sum -= numbers[left];
 *             left++;
 *         }
 *
 *     }
 *     if(count == Integer.MAX_VALUE) return 0;
 *     return count;
 *
 *     }
 *
 */
}

