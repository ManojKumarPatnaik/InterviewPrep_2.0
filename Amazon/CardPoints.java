package Amazon;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class CardPoints {

    static int maxSum = 0;

    private static void maxScore(int[] cardPoints, int k) {

        if (k == cardPoints.length) {
            int maxScore = 0;
            for (int points : cardPoints) {
                maxScore += points;
            }
            maxSum = maxScore;
        }

        findMaxScore(cardPoints, k, 0, cardPoints.length - 1, 0);

    }

    private static void findMaxScore(int[] cardPoints, int k, int leftPointer, int rightPointer, int sum) {

        if (k == 0) {
            if (sum > maxSum) {
                maxSum = sum;
            }
            return;
        }

        k = k - 1;
        sum = sum + cardPoints[leftPointer];
        findMaxScore(cardPoints, k, leftPointer + 1, rightPointer, sum);

        sum = sum - cardPoints[leftPointer] + cardPoints[rightPointer];
        findMaxScore(cardPoints, k, leftPointer, rightPointer - 1, sum);
    }

    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        maxScore(arr, 7);
        System.out.println(maxSum);

        System.out.println(maxScoreEfficient(arr, 3));

    }

    private static int maxScoreEfficient(int[] cardPoints, int k) {

        int tempSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            tempSum = tempSum + cardPoints[i];
        }
        maxSum = tempSum;
        if (k == cardPoints.length) {
            return maxSum;
        }
        int rightPointer = cardPoints.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            tempSum = tempSum - cardPoints[i] + cardPoints[rightPointer];
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
            rightPointer--;
        }
        return maxSum;

    }
}


