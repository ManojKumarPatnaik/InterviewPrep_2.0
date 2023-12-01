package Amazon;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/climbing-stairs/submissions/
//https://www.youtube.com/watch?v=NFJ3m9a1oJQ

public class StairClimb {

    //top down with memoization approach
        public int climbStairs(int n) {

            Map<Integer, Integer> stairVsWays = new HashMap<>();
            stairVsWays.put(1, 1);
            stairVsWays.put(2, 2);
            return findWays(n, stairVsWays);
        }

        private int findWays(int n, Map<Integer, Integer> stairWays) {

            if(stairWays.containsKey(n)) {
                return stairWays.get(n);
            }

            if(n == 0) {
                return 0;
            }

            int ways = findWays(n-1, stairWays) + findWays(n-2, stairWays);
            stairWays.put(n, ways);
            return  stairWays.get(n);
        }


    //bottom up with constant space
    public int climbStairsBottomUp(int n) {

        int ways1= 1; //for 0th floor
        int ways2= 1;  //for 1 floor, number of ways

        if (n==0) {
            return ways1;
        }
        if(n==1) {
            return ways2;
        }

        for(int i=2; i<=n-1; i++) {

            int temp = ways2 + ways1;
            ways1 = ways2;
            ways2 = temp;
        }

        return ways1 + ways2;
    }
}
