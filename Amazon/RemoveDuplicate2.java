package Amazon;

import java.util.PriorityQueue;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicate2 {

    private static int removeDuplicates(int[] nums) {

        int count =0;
        int j=0;
        for(int i=0; i<nums.length;i++) {

            if(count <2 || nums[i] != nums[j-2]) {
                nums[j] = nums[i];
                if(j> 0 && nums[j-1] != nums[i]) {
                    count =1;
                } else {
                    count++;
                }
                j++;
            }
        }


        return j;
    }

    //one more simple solution
    public int removeDuplicates2(int[] nums) {

        int i=0;
        for(int n : nums) {
            if(i<2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }

        return i;
    }

    public static void main(String args[]) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
        for(int num : nums)
        System.out.print(num + " ");

    }
}


