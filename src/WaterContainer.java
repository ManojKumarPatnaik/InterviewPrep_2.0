import java.util.*;

/**
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */

class WaterContainer {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }

        int maxWaterContained = findMaxWaterStoredInContainer(height);
        System.out.println(maxWaterContained);
    }

    private static int findMaxWaterStoredInContainer(int[] heights) {

        int leftWallIndex = 0;
        int rightWallIndex = heights.length - 1;
        int maxWater = 0;

        while (leftWallIndex < rightWallIndex) {

            int water = (rightWallIndex - leftWallIndex) * (heights[rightWallIndex] >= heights[leftWallIndex] ? heights[leftWallIndex] : heights[rightWallIndex]);

            if (water >= maxWater) {
                maxWater = water;
            }

            if (heights[leftWallIndex] < heights[rightWallIndex]) {
                leftWallIndex++;
            } else if (heights[leftWallIndex] > heights[rightWallIndex]) {
                rightWallIndex--;
            } else {
                leftWallIndex++;
                rightWallIndex--;
            }
        }
        return maxWater;
    }
}
