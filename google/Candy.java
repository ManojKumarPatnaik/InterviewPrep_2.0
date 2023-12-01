package google;

//https://leetcode.com/problems/candy/
public class Candy {


    //brute force
    public int candyBruteForce(int[] ratings) {
        int result = 0;
        boolean hasChanged = true;
        int candyCountArray[] = new int[ratings.length];
        for (int index = 0; index < candyCountArray.length; index++) {
            candyCountArray[index] = 1;
        }

        while (hasChanged) {
            hasChanged = false;
            for (int index = 0; index < ratings.length; index++) {
                if (index - 1 >= 0 &&
                        ratings[index] > ratings[index - 1] &&
                        candyCountArray[index] <= candyCountArray[index - 1]) {
                    candyCountArray[index] = candyCountArray[index - 1] + 1;
                    hasChanged = true;
                }
                if (index + 1 < ratings.length &&
                        ratings[index] > ratings[index + 1] &&
                        candyCountArray[index] <= candyCountArray[index + 1]) {
                    candyCountArray[index] = candyCountArray[index + 1] + 1;
                    hasChanged = true;
                }
            }
        }


        for (int candyCount : candyCountArray) {
            result += candyCount;
        }

        return result;
    }

    //efficient approach, O(N) time complexity
        public int candy(int[] ratings) {
            int result = 0;
            int candyCountArray[] = new int[ratings.length];

            for (int index = 0; index < candyCountArray.length; index++) {
                candyCountArray[index] = 1;
            }

            for (int leftToRightIndex = 1; leftToRightIndex < ratings.length; leftToRightIndex++) {

                if (ratings[leftToRightIndex] > ratings[leftToRightIndex - 1] &&
                        candyCountArray[leftToRightIndex] <= candyCountArray[leftToRightIndex - 1]) {

                    candyCountArray[leftToRightIndex] = candyCountArray[leftToRightIndex - 1] + 1;
                }
            }

            for (int rightToLeftIndex = ratings.length - 2; rightToLeftIndex >= 0; rightToLeftIndex--) {

                if (ratings[rightToLeftIndex] > ratings[rightToLeftIndex + 1] &&
                        candyCountArray[rightToLeftIndex] <= candyCountArray[rightToLeftIndex + 1]) {

                    candyCountArray[rightToLeftIndex] = candyCountArray[rightToLeftIndex + 1] + 1;
                }
            }

            for (int candyCount : candyCountArray) {

                result += candyCount;
            }

            return result;
        }

    public static void main(String args[]) {

        int[] ratings = {3,6,5,4};
        Candy candyObj = new Candy();
        System.out.println(candyObj.candyBruteForce(ratings));
    }


}
