package salesforce;


/*
Given a set of m distinct positive integers and a value ‘N’. The problem is to count the total number of ways we can form ‘N’ by doing sum of the array elements. Repetitions and different arrangements are allowed.

Input : arr = {1, 5, 6}, N = 7
6

5 1 1
6 1
1 1 1 1 1 1 1
1 5 1

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Question1 {

    static void addNumbers(int[] inputArray, int N, List outputList) {

        //1. Starting point is list of all numbers which are less than N

        List<Integer> numbersLesserThanN = findTheMinumumNumberList(inputArray ,  N);
        for(int index =0; index < numbersLesserThanN.size(); index++){

            int tempValue = N - numbersLesserThanN.get(index);

            if(tempValue == 0){
                //print the outputList
                for(int i =0; i<outputList.size(); i++ ) {
                    System.out.print(outputList.get(i));
                }
                System.out.print(numbersLesserThanN.get(index));
                System.out.println();

            } else {
                outputList.add(numbersLesserThanN.get(index));
                addNumbers(inputArray, tempValue, outputList);
            }
        }

        //remove the last element from the outputList
        if(!outputList.isEmpty())
        outputList.remove(outputList.size()-1);

    }


    private static List findTheMinumumNumberList (int[] inputArray, int N) {

        List minumumArrayValuesList = new ArrayList();
        for(int i=0; i< inputArray.length; i++){

            if(inputArray[i] <= N) {
                minumumArrayValuesList.add(inputArray[i]);
            }
        }

        return minumumArrayValuesList;
    }


    public static void main(String[] args) {

        int[] inputArray = new int[]{1,2,5};

        addNumbers(inputArray, 7, new ArrayList<>());
    }
}


