package Amazon;

import java.util.Stack;

//https://leetcode.com/problems/132-pattern/submissions/
public class Pattern132 {

    public static boolean find132pattern(int[] nums) {

        Stack<Integer> stackJ = new Stack<>();
        int secondLargestK = Integer.MIN_VALUE;
        for(int i= nums.length-1 ; i>=0; i--) {

            if(nums[i]<secondLargestK) {
                return true;
            }
            while(!stackJ.isEmpty() && stackJ.peek() < nums[i]) {
                secondLargestK = Math.max(secondLargestK,stackJ.pop());
            }
            stackJ.push(nums[i]);
        }
        return false;

    }

    public static void main(String args[]) {
        int[] nums = {1,0,1,-4,-3};
        System.out.println(find132pattern(nums));
    }
}
