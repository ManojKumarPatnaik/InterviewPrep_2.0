package oracle;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/jump-game/

        int[] inputArray = new int[]{3, 0, 8, 2, 0, 0, 1}; = false
        {2,3,0,1,4,5]

 */

//my solution
class OracleCanWeReachLast {
    public boolean canJump(int[] nums) {

        Map<Integer, Boolean> indexResultCache = new HashMap<>();

        return computeCanWeReachLast(nums, 0, false, indexResultCache);
    }

    private static boolean computeCanWeReachLast(int[] inputArray, int currentIndex, boolean reachedLast, Map<Integer, Boolean> indexResultCache) {

        if (indexResultCache.containsKey(currentIndex)) {
            return indexResultCache.get(currentIndex);
        }

        if (currentIndex >= inputArray.length - 1 ||
                (currentIndex + inputArray[currentIndex]) >= inputArray.length - 1 || reachedLast) {

            return true;
        }

        if (inputArray[currentIndex] == 0) {
            return false;
        }

        boolean isReachedToEnd = false;
        for (int jumpIndex = 1; jumpIndex <= inputArray[currentIndex]; jumpIndex++) {

            isReachedToEnd = computeCanWeReachLast(inputArray, currentIndex + jumpIndex, reachedLast, indexResultCache);
            if (isReachedToEnd) {
                reachedLast = true;
            }
        }

        indexResultCache.put(currentIndex, reachedLast);

        return isReachedToEnd;

    }
}


//efficient
//
//class Solution {
//    public boolean canJump(int[] nums) {
//        int maxPos = 0;
//        int finalPos = nums.length - 1;
//
//        for(int i = 0; i < nums.length && maxPos < finalPos; ++i) {
//            if(maxPos < i) {
//                return false;
//            }
//            maxPos = Math.max(maxPos, i + nums[i]);
//        }
//
//        return true;
//    }
//}
