import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*

https://leetcode.com/problems/minimum-jumps-to-reach-home/

Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
Output: 2
Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.

Below is DFS approach
 */

public class MinJumpReachHome {

    private static Map<String, Integer> cache;

    public static void main(String args[]) {

        int[] forbidden = {1, 4, 5, 6, 1, 1, 3};
        int a = 7;
        int b = 9;
        int x = 11;
        int minJumps = minimumJumps(forbidden, a, b, x);
        System.out.println(minJumps);
    }


    private static int minimumJumps(int[] forbidden, int a, int b, int x) {
        cache = new HashMap<>();

        //convert the int[] to IntegerList
        List<Integer> forbiddenList = Arrays.stream(forbidden).boxed().collect(Collectors.toList());
        Set<Integer> alreadyVisited = new HashSet<>();
        int jumps = findHomePath(forbiddenList, a, b, x, false, 0, 0, Integer.MAX_VALUE, alreadyVisited);
        return jumps;

    }

    private static int findHomePath(List<Integer> forbidden, int forwardJump, int backwardJump, int homePosition, boolean canGoBack, int currentPosition, int jumpsDone, Integer minimumJumps, Set<Integer> alreadyVisited) {

        if (cache.containsKey(currentPosition + "," + canGoBack)) {
            return cache.get(currentPosition + "," + canGoBack);
        }

        //if if reach my home position, return the jumps required to reach
        if (currentPosition == homePosition) {
            return jumpsDone;
        }

        int furthestPostion = 2000 + 2 * backwardJump;

        //alreadyVisited track is necessary, else while going to child and doing backjump, we might end up again at same point and it will become infinite loop
        alreadyVisited.add(currentPosition);


        // while jumping forward, if we have jump so much far that even going backward we are ahead from home position, means its no path ahead and we dont want to go further ahead
        int forwardJumpsResult = -1;
        int backwardJumpsResult = -1;

        //can i jump ahead
        if (currentPosition + forwardJump <= furthestPostion && !forbidden.contains(currentPosition + forwardJump) && !alreadyVisited.contains(currentPosition + forwardJump)) {

            forwardJumpsResult = findHomePath(forbidden, forwardJump, backwardJump, homePosition, true, currentPosition + forwardJump, jumpsDone + 1, minimumJumps, alreadyVisited);
        }

        //can i go back
        if (!alreadyVisited.contains(currentPosition - backwardJump) && canGoBack && (currentPosition - backwardJump) >= 0 && !forbidden.contains(currentPosition - backwardJump)) {

            backwardJumpsResult = findHomePath(forbidden, forwardJump, backwardJump, homePosition, false, currentPosition - backwardJump, jumpsDone + 1, minimumJumps, alreadyVisited);
        }


        if (forwardJumpsResult != -1) {
            minimumJumps = forwardJumpsResult < minimumJumps ? forwardJumpsResult : minimumJumps;
        }

        if (backwardJumpsResult != -1) {

            minimumJumps = backwardJumpsResult < minimumJumps ? backwardJumpsResult : minimumJumps;
        }

        alreadyVisited.remove(currentPosition);
        cache.put(currentPosition + "," + canGoBack, minimumJumps);
        return Integer.MAX_VALUE == minimumJumps ? -1 : minimumJumps;
    }

}
