package Amazon;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
public class KLargestInStream {

    PriorityQueue<Integer> minPriorityQueue;
    int size;

    public KLargestInStream(int k, int[] nums) {
        minPriorityQueue = new PriorityQueue<>();
        size = k;
        for(int num: nums) {
            add(num);
        }
    }

    public int add(int val) {

        minPriorityQueue.offer(val);
        while(minPriorityQueue.size() > size){
            minPriorityQueue.poll();
        }

        return minPriorityQueue.peek();

    }

    public static void main(String args[]) {

        KLargestInStream obj = new KLargestInStream(3, new int[]{4,5,8,2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));

    }
}

