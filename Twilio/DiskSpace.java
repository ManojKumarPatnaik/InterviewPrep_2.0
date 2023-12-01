package Twilio;

/*
A company is performing an analysis on the computers at its main office. The computers are spaced along a single row. For each group of contiguous computers of a certain length, that is, for each segment, determine the minimum amount of disk space available on a computer. Return the maximum of these values as your answer. Example n = 4 the number of computers space i = (8, 2, 4, 6); x = 2 the segment length The free disk space of computers in each of the segments is [8 21 [2, 4) (4, 6). The minima of the three segments are [2, 2. 41. The maximum of these is 4 Function Description Complete the function segment in the editor below. segment has the following parameterisk int x: the segment length to analyze int space(n): the available hard disk space on each of the computers
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/

//very similar: https://leetcode.com/problems/sliding-window-maximum/
//dequeue will help here

class Solution {

    //using PRIORITY QUEUE - NOT EFFICIENT
    public static int segment(int x, List<Integer> space) {
        int maxSpace = 0;
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        for (int i = 0; i < x; i++) {
            minpq.add(space.get(i));
        }
        int windowStart = 0;
        int windowEnd = x - 1;
        while (windowStart <= space.size() - x && windowEnd < space.size()) {

            int windowMinValue = minpq.peek();
            if (windowMinValue > maxSpace) {
                maxSpace = windowMinValue;
            }

            minpq.remove(space.get(windowStart));
            windowStart++;
            windowEnd++;
            if (windowEnd < space.size())
                minpq.add(space.get(windowEnd));
        }
        return maxSpace;
    }


    public static int[] segmentEfficient(int nums[], int k) {

        List<Integer> output = new ArrayList<>();

        Deque<Integer> maxDequeue = new LinkedList<>();
        int windowStart = 0;
        for (int i = 0; i < nums.length; i++) {
            //first, check if we are out of window, if yes then remove the
            // first element from the window if applicable
            if ((i - windowStart) >= k) {
                int maxValueIndex = maxDequeue.getFirst();
                if (maxValueIndex == windowStart) {
                    maxDequeue.removeFirst();
                }
                windowStart++;
            }

            //second, need to put the value in dequeue at Last and remove the smaller element in front of it
            while (!maxDequeue.isEmpty() && nums[maxDequeue.getLast()] < nums[i]) {
                maxDequeue.removeLast();
            }
            maxDequeue.offer(i);

            //third, check if we reached the window size and put the value in the output array
            if (i - windowStart == k - 1) {
                output.add(nums[maxDequeue.getFirst()]);
            }
        }

        int[] outputArr = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            outputArr[i] = output.get(i);
        }
        return outputArr;
    }


}

public class DiskSpace {
    public static void main(String[] args) throws IOException {

        List<Integer> space = new ArrayList<>();
        space.add(1);
        space.add(2);
        space.add(3);
        space.add(1);
        space.add(2);

        int x = 1;

        // System.out.println(Solution.segment(x, space));

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution.segmentEfficient(arr, 3);

    }
}