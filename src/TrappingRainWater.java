/*
https://leetcode.com/problems/trapping-rain-water/
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */

class TrappingRainWater {
    public static int trap(int[] height) {

        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int [height.length];

        int totalWaterSaved = 0;
        //1. fill up the left and right max height of the index
        computeIndexLeftAndMaxHeight(leftMaxHeight, rightMaxHeight, height);


        for(int i=0; i<height.length; i++) {

            int leftMax = leftMaxHeight[i];
            int rightMax = rightMaxHeight[i];
            int minHeight = Math.min(leftMax,rightMax);
            totalWaterSaved = totalWaterSaved + (minHeight-height[i] <= 0 ? 0 : minHeight-height[i]);
        }

        return totalWaterSaved;

    }


    private static void computeIndexLeftAndMaxHeight(int[] leftMaxHeight, int[] rightMaxHeight, int[] height) {

        leftMaxHeight[0] = 0;
        int leftMax = height[0];

        //filling left heights
        for(int i=1; i<height.length; i++) {

            leftMaxHeight[i] = leftMax;
            if(leftMax < height[i])
                leftMax = height[i];
        }

        //filling right heights
        rightMaxHeight[height.length-1] = 0;
        int rightMax = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {

            rightMaxHeight[i] = rightMax;
            if(rightMax < height[i])
                rightMax = height[i];
        }

    }

    public static void main(String args[]) {
        int[] arr= new int[]{4,2,0,3,2,5};
        System.out.println(trap(arr));
    }

}