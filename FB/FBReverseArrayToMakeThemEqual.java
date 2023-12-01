package FB;

import java.util.Map;

import java.util.*;

/*
https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2869293499822992&c=264896548841891&ppid=454615229006519&practice_plan=0
Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
Signature
bool areTheyEqual(int[] arr_a, int[] arr_b)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if B can be made equal to A, return false otherwise.
Example
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
output = true
After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 */

public class FBReverseArrayToMakeThemEqual {

    // Add any helper functions you may need here


    private static boolean areTheyEqual(int[] array_a, int[] array_b) {

        if(array_a.length != array_b.length) {
            return false;
        }

        Map<Integer, Integer> valueVsCount = new HashMap<>();

        for(int val : array_a) {
            valueVsCount.put(val, valueVsCount.getOrDefault(val,0)+1);
        }

        for(int val : array_b) {
            if(valueVsCount.containsKey(val) && valueVsCount.get(val) > 0) {
                valueVsCount.put(val, valueVsCount.get(val)-1);
            } else {
                return false;
            }
        }

        return true;


    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    private static void check(boolean expected, boolean output) {
        int test_case_number = 1;
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public static void main(String[] args) {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
    }
}
