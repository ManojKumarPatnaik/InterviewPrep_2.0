package Amazon;

//https://leetcode.com/problems/find-the-duplicate-number/
/*
should be constant space complexity
Linear and should not modify array
 */

//Complexity O(nlogn) count the number of bits
public class FindDuplicateNumber {

    private static int findDuplicate(int[] nums) {


        //find the max number
        int maxNumber = findMaxNumber(nums);
        int mostSignificantBitCount = 0;
        while(maxNumber >0) {
            maxNumber = maxNumber>>1;
            mostSignificantBitCount++;

        }
        int duplicate = 0;

        for(int i=0; i< mostSignificantBitCount; i++) {

            int baseCount =0;
            int originalCount =0;
            int mask = (1 << i);
            for(int j=0;j< nums.length; j++) {

                if( (j & mask) > 0) {
                    baseCount++;
                }

                if((nums[j] & mask) >0 ) {
                    originalCount++;
                }
            }

            if(originalCount> baseCount) {
                duplicate = duplicate | mask;
            }
        }

        return duplicate;

    }

    private static int findMaxNumber(int[] nums) {

        int max = 0;
        for(int n : nums ) {
            if(n > max) {
                max = n;
            }
        }
        return max;
    }

    private static int findDuplicate2(int[] nums) {

        int tortorise = nums[0];
        int hare = nums[0];

        do{
            tortorise = nums[tortorise];
            hare = nums[nums[hare]];

        } while(nums[tortorise] != nums[hare]);

        tortorise = nums[0];
        while (tortorise != hare){

            tortorise = nums[tortorise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String args[]) {
        int[] nums = {1,3,4,2,2};
        int output = findDuplicate(nums);
        System.out.println(output);

    }
}
