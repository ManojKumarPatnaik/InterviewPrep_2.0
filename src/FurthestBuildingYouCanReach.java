import java.util.PriorityQueue;

/*
https://leetcode.com/problems/furthest-building-you-can-reach/
nput: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
Output: 4
Explanation: Starting at building 0, you can follow these steps:
- Go to building 1 without using ladders nor bricks since 4 >= 2.
- Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
- Go to building 3 without using ladders nor bricks since 7 >= 6.
- Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 */

/*
approach:

logic here is, we first use min heap to use the jump till we have ladder, after that, we check if diff is bigger than min value of heap, then can we swap it with bricks or not.
so that we will always use ladder for bigger jumps only.
 */
public class FurthestBuildingYouCanReach {


    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {

            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) {
                continue;
            }
            //till min priority queue does not reach to the size of ladder, insert into it in increasing order
            if (minPq.size() < ladders) {
                minPq.offer(diff);
            } else {
                //once queue is fill then we will check if. we can
                //swap bricks with ladder, if new diff is bigger than what is there in queue, as ladder need to be used for bigger only.
                if (minPq.size() > 0 && minPq.peek() < diff) {

                    if (bricks >= minPq.peek()) {
                        int swapWithLadder = minPq.peek();
                        minPq.remove();
                        minPq.offer(diff);
                        bricks = bricks - swapWithLadder;

                    } else {
                        //means you can not even use bricks for min value for which ladder is already used. so we cannot jump forward.
                        return i - 1;
                    }
                } else {
                    //means ladder is already used for bigger jump, and this jump check if we can use brick or not
                    if (bricks >= diff) {
                        bricks = bricks - diff;
                    } else {
                        return i - 1;
                    }
                }

            }
        }

        //we reached till last.
        return heights.length - 1;

    }
}
