package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {


    private static int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> charFreqMap = new HashMap<>();
        //Storing the frequency of each tasks
        for (char c : tasks) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        //using max heap, because the tasks which are occurring more, should be started first  (kind of greedy approach)
        //ex: A, B, C, C , here C is occuring more, so if we start C first, in this seq, it C B A C, it gives optimum solution
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(charFreqMap.values());
        int count = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            //picking the top N+1 tasks from the HEAP, why n+1 because between 2 same tasks i need to give n gap
            // so task(1unit) + n unit gap  = n+1,
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty())
                    tempList.add(maxHeap.remove());
            }
            // adding it back in the heap if there are more tasks
            for (Integer i : tempList) {
                if (i != null && --i > 0) {
                    maxHeap.add(i);
                }
            }
            //if heap is not empty, then we need to do n+1, because ex: AAAAAA, after 1st iteration
            // it should be A idle idle  , so n+1 (2+1) is added to the count. and for rest A, loop will continue.
            count += maxHeap.isEmpty() ? tempList.size() : n + 1;
        }
        return count;
    }



    public static void main(String args[]) {

        char[] tasks = {'A','B','C','C'};
        int n=2;
        System.out.println(leastInterval(tasks,n));

    }
}