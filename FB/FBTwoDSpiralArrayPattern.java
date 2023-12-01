package FB;/*
https://www.facebook.com/careers/life/sample_interview_questions

Question 1: 2D Spiral Array
Find the pattern and complete the function:
int[][] spiral(int n);
where n is the size of the 2D array.
Sample Result
input = 3
123
894
765

input = 4
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07

input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15
 */

public class FBTwoDSpiralArrayPattern {

    public static void main(String args[]) {

        int[][] output =  spiral(3);
        for(int i =0; i< 3; i++) {
            for( int j=0; j< 3; j++) {
                System.out.print(" " + output[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] spiral(int n) {

        if (n<=0) {
            throw new IllegalArgumentException("N must be >0");
        }
        int[] dc = new int[]{1,0,-1,0};
        int[] dr = new int[]{0,1,0,-1};
        int dir = 0, val=0, r=0, c=0,limit=n*n;
        int[][] matrix = new int[n][n];
        while (val++ < limit) {
            matrix[r][c] = val;
            r += dr[dir];
            c += dc[dir];
            if (isInvalid(matrix,r, c)) {
                r-= dr[dir];
                c-=dc[dir];
                dir = (dir+1)%4;
                r+= dr[dir];
                c+= dc[dir];
            }
        }
        return matrix;
    }
    private static boolean isInvalid(int[][] m, int r, int c) {
        return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
    }
}
