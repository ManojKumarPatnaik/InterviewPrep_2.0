package FB;
//https://leetcode.com/discuss/interview-question/742523/facebook-prep-question-contiguous-subarrays-on-solution

/*
Contiguous Subarrays
You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end on index i.
Signature
int[] countSubarrays(int[] arr)
Input
Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
Size N is between 1 and 1,000,000
Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
 */

import java.util.Stack;

//sol1 O(n2)
public class FBContigiousSubarrayIndexShouldBeMax {

    int[] countSubarrays(int[] arr) {
        // Write your code here

        int arrayLength = arr.length;
        int[] outputArray = new int[arrayLength];

        for(int i=0; i< arrayLength; i++) {

            int indexNumber = arr[i];
            int count = 1;
            //for each index, we need to iterate over its left
            for(int left = i-1; left>=0; left--) {

                if(arr[left] < indexNumber) {
                    count++;
                } else {
                    break;
                }
            }

            //for each index, we need to iterate over its right
            for(int right = i+1; right < arrayLength; right++) {

                if(arr[right] < indexNumber) {
                    count++;
                } else {
                    break;
                }
            }

            outputArray[i] = count;


        }

        return outputArray;

    }

    //sol2: 0(n)

    /*

    1. take one stack
    2. first iterate the array , and first try to find out contigious left subarray
        so for:  3,4,1,6,2
        in the result array: [1, 2, 1, 4, 1]
        how:
            first 3 does not have anything in its left, so put 1 in result array and in stack put Stack.push[0] index we need to push
            now, for 4, we check from stack, if array[stack[peek]] (stack top value) is lower than current value which is 4, then pop from the
            stack and increase the count. if value is lower than top value of stack , then simply push and count is 1 for that only.

            if stack is empty, then store the count at that result index.

     3. now second time iterate for right contigius subarry, with same procedure. and update the same result array

     we just need to reduce 1 from result arraay, because say value 4, is counted twice during left and right subarray

     O(2N) ~ O(N)

     */

    int[] countSubarrays2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        result[0] = 1;
        // For every index, check from the left for possible contiguous arrays
        stack.push(0);
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop(); // pop the stack elements till arr[stack top] is greater than or equal to the current element
            // after the above step either stack is empty or stack top is the max element and hence contiguous sub-arrays having max element at i are only possible till the stack top
            if(stack.isEmpty()) result[i] = i + 1;
            else result[i] = i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        // For every index, check from the right for possible contiguous arrays
        stack.push(arr.length - 1);
        for(int i = arr.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
            // after the above step either stack is empty or stack top is the max element and hence contiguous sub-arrays having max element at i are only possible till the stack top
            if(stack.isEmpty()) result[i] += (arr.length - i - 1);
            else result[i] += (stack.peek() - i - 1);
            stack.push(i);
        }
        return result;

    }

}
