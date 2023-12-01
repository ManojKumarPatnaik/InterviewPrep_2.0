import java.util.Arrays;
/*

https://leetcode.com/problems/k-closest-points-to-origin/submissions/
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */



public class KClosestPointsOrigin {

    public int[][] kClosest(int[][] points, int k) {

        //find the distance of each points

        int[] distance = new int[points.length];
        int[][] output = new int[k][2];

        for(int index = 0; index<points.length; index++) {

            int x = points[index][0];
            int y = points[index][1];
            distance[index] = x*x + y*y;
        }

        Arrays.sort(distance);

        int minDistancePoint = distance[k-1];

        int outval = 0;
        for(int index = 0; index<points.length; index++) {

            int x = points[index][0];
            int y = points[index][1];
            int val = x*x + y*y;

            if(val <= minDistancePoint){
                output[outval][0] = x;
                output[outval][1] = y;
                outval++;
            }

            if(outval == k) {
                break;
            }

        }


        return output;


    }
}
