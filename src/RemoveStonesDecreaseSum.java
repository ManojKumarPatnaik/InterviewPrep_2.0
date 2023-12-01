import java.util.Collections;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/remove-stones-to-minimize-the-total/
Input: piles = [5,4,9], k = 2
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [5,4,5].
- Apply the operation on pile 0. The resulting piles are [3,4,5].
The total number of stones in [3,4,5] is 12.
 */


class RemoveStonesDecreaseSum {

        public int minStoneSum(int[] piles, int k) {


            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            int sum = 0;

            for(int i = 0; i<piles.length; i++) {

                maxHeap.add(piles[i]);
                sum += piles[i];

            }

            while(k>0) {
                //1. get and remove the first element
                double maxValue = maxHeap.poll();

                //divided by 2
                int newVal =  (int) Math.ceil(maxValue/2);

                sum -= (maxValue-newVal);
                maxHeap.add(newVal) ;
                k--;

            }
            return sum;
        }
}

