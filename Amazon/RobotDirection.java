package Amazon;

// https://leetcode.com/problems/robot-bounded-in-circle/
public class RobotDirection {


    private static boolean isRobotMakesCircle(String I) {
                    //north, left, south, right
        int[][] d = {{0, 1},{-1, 0},{0, -1},{1, 0}};
        int di = 0, x = 0, y = 0;

        for (int i = 0; i < I.length(); i++) {
            switch (I.charAt(i)) {
                case 'L':
                    di = (di + 1) % 4;
                    break;
                case 'R':
                    di = (di + 3) % 4;
                    break;
                default:
                    x = x + d[di][0];
                    y = y + d[di][1];
            }
        }
        if (x == 0 && y == 0 || di > 0)
            return true;
        return false;
    }

    public static void main(String args[]) {

        String I = "GLR";
        System.out.println(isRobotMakesCircle(I));
    }

}
