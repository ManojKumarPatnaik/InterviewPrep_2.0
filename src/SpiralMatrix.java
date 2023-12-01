import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

//better approach in FBPrep.FBTwoDSpiralArrayPattern class
 */

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        int[][] goRightStartPoint = {{0,0}};
        int[][] goDownStartPoint = {{0,columnCount-1}};
        int[][] goLeftStartPoint = {{rowCount-1,columnCount-1}};
        int[][] goTopStartPoint = {{rowCount-1,0}};



        while(goRightStartPoint[0][0]  <= goLeftStartPoint[0][0] && goTopStartPoint[0][1] <= goDownStartPoint[0][1]) {


            int i=goRightStartPoint[0][0];
            int j=goRightStartPoint[0][1];


            //check if its single row
            if(goDownStartPoint[0][0] ==  i  && goLeftStartPoint[0][0] ==  i && goTopStartPoint[0][0] ==  i ) {
                while(j<=goDownStartPoint[0][1]) {
                    output.add(matrix[i][j]);
                    j++;
                }
                break;
            }

            //check if its single column
            if(goDownStartPoint[0][1] ==  j  && goLeftStartPoint[0][1] ==  j && goTopStartPoint[0][1] ==  j ) {
                while(i<=goLeftStartPoint[0][0]) {
                    output.add(matrix[i][j]);
                    i++;
                }
                break;
            }


            //going right
            while(j < goDownStartPoint[0][1]) {
                output.add(matrix[i][j]);
                j++;
            }


            //going bottom

            while(i < goLeftStartPoint[0][0] ) {
                output.add(matrix[i][j]);
                i++;
            }

            //going left

            while(j > goTopStartPoint[0][1]) {
                output.add(matrix[i][j]);
                j--;
            }

            //going top

            while(i > goRightStartPoint[0][0]) {
                output.add(matrix[i][j]);
                i--;
            }

            goRightStartPoint[0][0] = goRightStartPoint[0][0] + 1;
            goRightStartPoint[0][1] = goRightStartPoint[0][1] + 1;

            goDownStartPoint[0][0] = goDownStartPoint[0][0] + 1;
            goDownStartPoint[0][1] = goDownStartPoint[0][1] - 1;

            goLeftStartPoint[0][0] = goLeftStartPoint[0][0] - 1;
            goLeftStartPoint[0][1] = goLeftStartPoint[0][1] - 1;

            goTopStartPoint[0][0] = goTopStartPoint[0][0] - 1;
            goTopStartPoint[0][1] = goTopStartPoint[0][1] + 1;


        }


        return output;
    }
}