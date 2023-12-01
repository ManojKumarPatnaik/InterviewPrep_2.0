package goldmansach;

/*
 Problem Name is &&& Election &&& PLEASE DO NOT REMOVE THIS LINE.

import java.io.*;
import java.util.*;




public class Solution {

    /**
     * A group of students are sitting in a circle. The teacher is electing a new class president.
     * The teacher does this by singing a song while walking around the circle. After the song is
     * finished the student at which the teacher stopped is removed from the circle.
     *
     * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
     * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
     *
     * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
     *
     * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
     * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
     *
     * @param n the number of students sitting in a circle.
     * @param k the length (in students) of each song.
     * @return the number of the student that is elected.

    public static int whoIsElected(int n, int k) {

        if(n == 1) return 1;

        List<Integer> students = new ArrayList<>();
        for(int i=1; i<=n;i++){
            students.add(i);
        }


        int tempIndex = 0;
        int studentsPassThrough = 0;

        while(tempIndex < students.size() && students.size() > 1) {

            studentsPassThrough++;
            if(studentsPassThrough == k) {

                boolean isLastelementRemoved = (tempIndex == students.size()-1) ? true: false;
                students.remove(tempIndex);


                studentsPassThrough = 0;
                if(isLastelementRemoved)
                {
                    tempIndex = 0;

                }

                n= n-1;
            } else{

                tempIndex = (tempIndex+1)%n;
            }

        }


        return students.get(0);
    }


    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        // test cases are structered as {n, k, expected answer}
        int[][] testCases = {
                {1, 1, 1},
                {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
                {5, 3, 4},
                {6, 4, 5},
                {1000, 5, 763}
        };

        for (int[] testCase : testCases) {
            int answer = whoIsElected(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    }

    /**
     * Execution entry point.

    public static void main(String args[]) {
        doTestsPass();
    }
}

 */

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
public class FindTheLeaderInCircle {

    public static void main(String args[]) {

        int n=100;
        int k=3;

        List<Integer> players = new ArrayList<>();
        for(int i =1; i<=n; i++) {
            players.add(i);
        }

        findWinner(players, k-1, 0);

        System.out.println(players.get(0));
    }

    private static void findWinner(List<Integer> players, int k, int index) {

        if(players.size() == 1) {
            return;
        }

        index = (index+k)%players.size();
        players.remove(index);

        findWinner(players, k, index);


    }
}
