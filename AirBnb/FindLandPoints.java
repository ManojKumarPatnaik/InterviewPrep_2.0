package AirBnb;

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class FindLandPoints {

    static int getTotalLandPoints( String[][] landMatrix) {


        //have visited matrix to track the visited points , 0 - unvisted and 1- visted
        int[][] visitedMatrix = new int[landMatrix.length][landMatrix[0].length];

        //we need to run till all the points in visitedMatrix is not marked as 1 (visited)

        int output = 0;
        while(isUnvisitedNodePresent(visitedMatrix)) {

            int[][] startPoint = getUnvisitedNode(visitedMatrix);

            char landType = landMatrix[startPoint[0][0]][startPoint[0][1]].charAt(0);
            int[][]   landCountvsLandPoint = new int[1][2];
            findTotalLandPointFromStartPoint(landMatrix,visitedMatrix, startPoint[0][0], startPoint[0][1], landType, landCountvsLandPoint);

            System.out.println( (landCountvsLandPoint[0][0] * landCountvsLandPoint[0][1]));
            output = output + (landCountvsLandPoint[0][0] * landCountvsLandPoint[0][1]);
        }

        return output;

    }


    static void findTotalLandPointFromStartPoint(String[][] landMatrix, int[][] visitedMatrix,  int x, int y,  char landType, int[][] landCountvsLandPoint) {

        if(x<0 || y<0 || x>=landMatrix.length || y>= landMatrix[0].length || visitedMatrix[x][y] == 1 || landType != landMatrix[x][y].charAt(0)) return;


        landCountvsLandPoint[0][0] = landCountvsLandPoint[0][0] + 1;
        if(Integer.valueOf(landMatrix[x][y].charAt(1))  - 48 != 0)
            landCountvsLandPoint[0][1] = landCountvsLandPoint[0][1] + (Integer.valueOf(landMatrix[x][y].charAt(1)) - 48);

        visitedMatrix[x][y] = 1;

        //top
        findTotalLandPointFromStartPoint(landMatrix, visitedMatrix, x-1, y, landType, landCountvsLandPoint);

        //bottom
        findTotalLandPointFromStartPoint(landMatrix, visitedMatrix, x+1, y, landType, landCountvsLandPoint);

        //left
        findTotalLandPointFromStartPoint(landMatrix, visitedMatrix, x, y-1, landType, landCountvsLandPoint);

        //right
        findTotalLandPointFromStartPoint(landMatrix, visitedMatrix, x, y+1, landType, landCountvsLandPoint);
    }



    static int[][] getUnvisitedNode(int[][] visitedMatrix) {

        int[][] unvisitedNode = new int[1][2];
        boolean found = false;

        for(int i=0; i<visitedMatrix.length; i++) {
            for(int j=0; j<visitedMatrix[0].length; j++) {

                if(visitedMatrix[i][j] == 0) {
                    unvisitedNode[0][0] = i;
                    unvisitedNode[0][1] = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        return unvisitedNode;
    }

    static boolean isUnvisitedNodePresent(int[][] visitedMatrix) {

        for(int i=0; i<visitedMatrix.length; i++) {
            for(int j=0; j<visitedMatrix[0].length; j++) {

                if(visitedMatrix[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] input = {
        {"G0", "W1", "W1", "W0", "P2"},
        {"W0", "W0", "F0", "F0", "F0"},
        {"W0", "W1", "F0", "S2", "S1"},
        {"G0", "X0", "G1", "G0", "G0"},
        {"S0", "M2", "M0", "G1", "F0"}};

        int sum = getTotalLandPoints(input);
        System.out.println(sum);
    }
}

/*

 input.add("G0 W1 W1 W0 P2");
    input.add("W0 W0 F0 F0 F0");
    input.add("W0 W1 F0 S2 S1");
    input.add("G0 X0 G1 G0 G0");
    input.add("S0 M2 M0 G1 F0");

//7 * 3 = 21 + 0 + 2 +...... + 8 = total


/*

time complexity: O(n2)
space complexity: 2 * O(n2) = O(n2)
caller() {

    output;
 till all all not marked as visited
take the next  unvisted point from  from vistedMatrix
output+=indTotalPoint(unvisted point x and y axis)
}

int findTotalPoint(int[][], startPointx, startPointy, char landType, int point, int landCount)

//char split
 x>0 , y>0 x<length of rows, y<total no of columns, point should not be visited , landType should be equal to the x and y axis land type



 landCount+=1
 add ot the point variable if the point is not 0


- findTotalPoint(x+1,y) //bottom
findTotalPoint(x-1,y) //top
findTotalPoint(x,y+1) // right
findTotalPoint(x+1,y) //left


retunr landCount*points;

                            ]


 ]

 */
