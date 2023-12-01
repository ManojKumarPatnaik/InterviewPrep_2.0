package MorganStanley;//was given this question in an OA and couldnt solve it in time. I thought it was interesting and solved it 3 hours latter.
//
//Find the minimum number of groups who's sum of each group is at max 3, and every element must be in a group.
//Given an Array like: [1.01, 1.01, 3.0, 2.7, 1.99, 2.3, 1.7]
//return the minimum number of groups, in this case it would be 5 groups: (1.01 , 1.99), (1.01, 1.7), (3.0), (2.7), (2.3)
//Constraint: all elements are between 1.01-3 inclucsive, and each groups sum is at max 3

import java.util.Arrays;
//https://leetcode.com/discuss/interview-question/490066/efficient-janitor-efficient-vineet-hackerrank-oa
public class MorganStanley {


    private static int minDayRequiredToComplete(float[] movieDuration) {

        int dayRequired =0;

        //1. sort the array
        //O(nlogn)
        Arrays.sort(movieDuration);
        int startIndex =0;

        //O(n)
        for(int endIndex=movieDuration.length-1; endIndex>=startIndex; endIndex--){
            if(movieDuration[endIndex] > 1.99f) {
                dayRequired++;
            } else if(movieDuration[endIndex] <= 1.99f) {

                if (startIndex!= endIndex && movieDuration[startIndex] + movieDuration[endIndex] <= 3f ){
                    startIndex++;
                }
                dayRequired++;
            }
        }
        return dayRequired;
    }


    public static void main(String args[]){


        float[] movieDuration1 ={2.1f,2.1f,2.1f,2.1f,2.1f,2.1f,2.1f,2.1f,2.1f,2.1f};
        float[] movieDuration2 ={1.90f,1.04f,1.25f,2.5f,1.75f};
        float[] movieDuration3 ={1.01f,1.01f,1.01f, 1.25f,2.4f};
        float[] movieDuration4 ={1.01f,1.01f,1.99f, 1.99f};

        System.out.println(minDayRequiredToComplete(movieDuration4));

    }

}
