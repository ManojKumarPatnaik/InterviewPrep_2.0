package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://leetcode.com/problems/combination-sum-ii/

similar:
https://leetcode.com/problems/combinations/
 */

public class CombinationSum2 {


    public static void main(String args[]) {

        int[] input = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(input);
        int target = 8;
        List<List<Integer>> output = new ArrayList<>();
        findWays(input, target, new ArrayList<>(), output, 0);
        for (List<Integer> o : output) {
            for (Integer val : o) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void findWays(int[] input, int target, List<Integer> tempList, List<List<Integer>> output, int startIndex) {

        if (target == 0) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < input.length && target >= input[i]; i++) {
            if (i > startIndex && input[i] == input[i - 1])
                continue;
            tempList.add(input[i]);
            findWays(input, target - input[i], tempList, output, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
