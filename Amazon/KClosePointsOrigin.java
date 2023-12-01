package Amazon;

import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosePointsOrigin {

    private static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minPQ = new PriorityQueue<>(k-1, (a, b) -> {

            return (a[0]*a[0]+ a[1]*a[1]) - ( (b[0]*b[0]+ b[1]*b[1]));
        });

        for(int[] arr: points) {
            minPQ.offer(arr);
        }

        int[][] output = new int[k][2];

        int i=0;
        while(!minPQ.isEmpty() && i<k) {
            int[] minArray = minPQ.poll();
            output[i][0] = minArray[0];
            output[i][1] = minArray[1];
            i++;
        }

        return output;

    }

    public static void main(String args[]) {
        int[][] nums = {{3,3}, {5,-1}, {-2,4}};
        kClosest(nums,2);
        for(int[] num : nums)
            System.out.println(num[0] + " " + num[1]);

    }
}

