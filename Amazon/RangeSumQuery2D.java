package Amazon;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class RangeSumQuery2D {

    private int[][] preComputedMatrix;

    public void numMatrix(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) return;

        preComputedMatrix = new int[matrix.length + 1][matrix[0].length + 1];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                preComputedMatrix[r + 1][c + 1] =
                        preComputedMatrix[r + 1][c] + preComputedMatrix[r][c + 1] +
                                matrix[r][c] - preComputedMatrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preComputedMatrix[row2 + 1][col2 + 1] -
                preComputedMatrix[row1][col2 + 1] -
                preComputedMatrix[row2 + 1][col1] +
                preComputedMatrix[row1][col1];
    }
}
