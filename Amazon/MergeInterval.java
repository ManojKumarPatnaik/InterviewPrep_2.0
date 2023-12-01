package Amazon;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.com/problems/merge-intervals/
//
public class MergeInterval {

    public static int[][] merge(int[][] intervals) {

        //sort based on the first element
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


        //for output using LinkedList, because, we need to compare with the last element
        LinkedList<int[]> output = new LinkedList<>();

        for (int[] interval : intervals) {
            //there is an overlap if second array first element is <= first array or computed array second element,
            //so if there is no overlap, i need to store in the output
            if (output.isEmpty() || output.getLast()[1] < interval[0]) {
                output.add(interval);
            } else {

                //if there is overlap, we need to update the output array
                output.getLast()[1] = Math.max(output.getLast()[1], interval[1]);
            }
        }

        for(int[] val : output) {

            System.out.println(val[0]);
        }

        return output.toArray(new int[output.size()][]);

    }

    public static void main(String args[]) {
        int[][] x= {{1,3},{2,6}};
        merge(x);
    }
}
