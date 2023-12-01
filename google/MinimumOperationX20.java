package google;

public class MinimumOperationX20 {

    public int minOperations(int[] nums, int x) {
        int leftPointer = 0, rightPointer = nums.length-1;
        int sum=0, minOperation = 0, output=Integer.MAX_VALUE;

        while(leftPointer<nums.length){
            sum = sum + nums[leftPointer];
            minOperation++;
            if(sum == x){
                output = minOperation;
                break;
            } else if(sum > x){
                break;
            }
            leftPointer++;
        }
        while (rightPointer >=0 && leftPointer <= nums.length-1) {
            if(sum+ nums[rightPointer] > x){
                if(leftPointer >= rightPointer) {
                    break;
                }
                sum = sum - nums[leftPointer];
                minOperation--;
                leftPointer--;
                if(leftPointer<0) {
                    leftPointer = nums.length-1;
                }
                continue;
            }
            sum = sum + nums[rightPointer];
            minOperation++;

            if(sum == x){
                output = Math.min(output, minOperation);
            }
            rightPointer--;
        }

        return output == Integer.MAX_VALUE ? -1 : output;
    }

    public static void main(String args[]) {

        int[] nums = {10, 1, 1, 1, 1, 1};
        int x = 5;
        MinimumOperationX20 obj = new MinimumOperationX20();
        System.out.println(obj.minOperations(nums, x));

    }
}
