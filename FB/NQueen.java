package FB;

import java.util.HashSet;

//https://leetcode.com/problems/n-queens-ii/
public class NQueen {

    int output;

    public int totalNQueens(int n) {
        HashSet<Integer> diagonal = new HashSet<>();
        HashSet<Integer> antiDiagonal = new HashSet<>();
        HashSet<Integer> vertical = new HashSet<>();
        HashSet<Integer> horizontal = new HashSet<>();
        fndAllQueenPositions(n, 0, diagonal, antiDiagonal, vertical, horizontal);
        return output;
    }

    public boolean fndAllQueenPositions(int n, int queenRow,
                              HashSet<Integer> diagonal, HashSet<Integer> antiDiagonal,
                              HashSet<Integer> vertical, HashSet<Integer> horizontal) {
        if (queenRow == n) {
            return true;
        }

        for (int column = 0; column < n; column++) {

            //queen is in danger
            if (diagonal.contains(queenRow - column) ||
                    antiDiagonal.contains(queenRow + column) ||
                    vertical.contains(column) || horizontal.contains(queenRow)) {

                continue;
            }

            //place the queen by marking diagonals, vertical and horizontal row into danger list
            vertical.add(column);
            horizontal.add(queenRow);
            diagonal.add(queenRow - column);
            antiDiagonal.add(queenRow + column);

            boolean foundPath = fndAllQueenPositions(n, queenRow + 1, diagonal, antiDiagonal,
                    vertical, horizontal);

            if(foundPath){
                output = output+1;
            }

            vertical.remove(column);
            horizontal.remove(queenRow);
            diagonal.remove(queenRow - column);
            antiDiagonal.remove(queenRow + column);
        }

        return false;
    }

    public static void main(String args[]) {

        int n = 4;
        NQueen obj = new NQueen();
        System.out.println(obj.totalNQueens(n));
    }
}
