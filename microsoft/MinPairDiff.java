package microsoft;

import java.util.Arrays;
import java.util.Collections;


// 2 array find the minimum pair diff (closed to 0), array can have + and - numbers

//better approach: https://www.youtube.com/watch?v=EyPV7iEr810

public class MinPairDiff {

    public static void main(String args[]) {

        int A[] = {-1,5,10,20, 28,3};
        int B[] = {26,134,135,15,17};

        int[] output = findMinPair(A, B);

        for(int value: output) {
            System.out.print(value + " ");
        }

    }

    private static int[] findMinPair(int[] A, int[] B) {

        int indexA = -1;
        int indexB = -1;
        int minDiff = Integer.MAX_VALUE;

        //sort B
        Arrays.sort(B);

        //for each element in A, find nearest element in B

        for(int index = 0; index < A.length; index++) {

            int currentElement = A[index];
            int nearestElementIndexFromB = findMiniumBElementIndex(B, currentElement);
            int diff = Math.abs(currentElement-B[nearestElementIndexFromB]);
            if(diff < minDiff) {
                minDiff = diff;
                indexA = index;
                indexB = nearestElementIndexFromB;
            }
        }

        int[] outputArry = {A[indexA], B[indexB]};
        return outputArry;

    }


    private static int findMiniumBElementIndex(int[] B, int currentElement) {

        int startIndex = 0;
        int lastIndex = B.length-1;
        int minIndex = search(B, startIndex, lastIndex, currentElement);
        return minIndex;
    }


    private static int search(int[] B, int startIndex, int lastIndex,  int currentElement) {

        //breaking condition here
        if(startIndex > lastIndex)  {
            return startIndex;
        }

        int mid= startIndex + (lastIndex - startIndex)/2;

        //first look at mid itself
        if(Math.abs(B[mid]) == currentElement) {
            return mid;
        }

        int diffFromMid = Math.abs(B[mid] - currentElement);
        int diffFromLeftSubarray = diffFromMid;
        if(mid != 0)
            diffFromLeftSubarray = Math.abs(B[mid-1] - currentElement);

        int diffFromRightSubarray = diffFromMid;
        if(mid != B.length-1)
            diffFromRightSubarray = Math.abs(B[mid+1] - currentElement);

        if (mid!=0 && diffFromLeftSubarray < diffFromMid) {
            search(B, startIndex, mid - 1, currentElement);
        } else if (mid != B.length-1 && diffFromRightSubarray < diffFromMid) {

            search(B, mid+1, lastIndex, currentElement);
        }

        return mid;

    }

}

//Time complexity : O(nlogn)