import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/3sum/
 * 
 *Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
class ThreeSum {

    public static void main(String args[]) {
        int [] array = new int [] {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(array);
        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 0 || nums.length < 3) {

            return result;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length-1;i++) {

            for(int j = i+1, k=nums.length-1; j<k; ) {


                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tripletFound = new ArrayList<>();
                    tripletFound.add(nums[i]);
                    tripletFound.add(nums[j]);
                    tripletFound.add(nums[k]);
                    result.add(tripletFound);
                    j++;
                } else if(nums[i] + nums[j] + nums[k] < 0) {

                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}