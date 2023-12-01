package AirBnb;

//https://leetcode.com/problems/wiggle-subsequence/solution/
public class WiggleSubsequence {

    static int DIRECTION_UP = 1;
    static int DIRECTION_DOWN = -1;
    static int DIRECTION_UNKOWN = 0;

    public int wiggleMaxLength(int[] nums) {

        int direction = DIRECTION_UNKOWN;
        int count = 0;

        if (nums.length < 2) {
            return nums.length;
        }

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {

                if (direction == DIRECTION_DOWN) {
                    count++;
                }
                direction = DIRECTION_UP;

            } else if (nums[i] < nums[i - 1]) {

                if (direction == DIRECTION_UP) {
                    count++;
                }
                direction = DIRECTION_DOWN;
            }
        }

        if (direction == DIRECTION_UNKOWN) {
            return count + 1;
        } else {
            return count + 2;
        }
    }


    private int calculateWiggleLength(int[] nums, int currentIndex, boolean directionUp) {
        int maxcount = 0;
        for (int i = currentIndex + 1; i < nums.length; i++) {
            if ((directionUp && nums[i] > nums[currentIndex]) || (!directionUp && nums[i] < nums[currentIndex]))
                maxcount = Math.max(maxcount, 1 + calculateWiggleLength(nums, i, !directionUp));
        }
        return maxcount;
    }

    public int wiggleMaxLengthRecursion(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        return 1 + Math.max(calculateWiggleLength(nums, 0, true),
                calculateWiggleLength(nums, 0, false));
    }
}