package Amazon;

import java.util.PriorityQueue;

public class FindMedianDataStream {

    PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    int totalNum = 0;
    boolean isNumLessThanZero = false;


    public FindMedianDataStream() {

    }

    public void addNum(int num) {


        totalNum += 1;

        if (maxPQ.isEmpty()) {
            maxPQ.offer(num);
            return;
        }

        if (minPQ.isEmpty() && num >= maxPQ.peek()) {
            minPQ.offer(num);
            return;
        }

        if (num < maxPQ.peek()) {
            //can i put in maxPQ
            if (maxPQ.size() - minPQ.size() > 0)
                minPQ.offer(maxPQ.poll());
            maxPQ.offer(num);

        } else if (num > minPQ.peek()) {
            //can i put in min
            if (!(minPQ.size() < maxPQ.size()))
                maxPQ.offer(minPQ.poll());
            minPQ.offer(num);

            } else {
                if (minPQ.size() == maxPQ.size()) {
                    maxPQ.offer(num);
                } else {
                    minPQ.offer(num);
                }
            }


        }

        public double findMedian () {

            double val = 0;
            if (totalNum % 2 == 0) {
                val = (double) (maxPQ.peek() + minPQ.peek()) / 2;

            } else {

                val = maxPQ.peek();
            }

            return val;

        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */