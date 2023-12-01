package Amazon;

class GameLife {
    public  static void gameOfLife(int[][] board) {

        /*
         taking 2 bit

 all possible usecases are
 nextstate , currentstate
         0 , 0 = 0
         0 , 1 = 1
         1 , 0 = 2   (whenever we want to change to 1 from 0 we will assign 2)
         1 , 1 = 3   (whenever current state is 1 and next state to be 1, we will assign 3 to board)

        Now during neighbour finding, we only need to consider CurrentState so do '& 1'
        and during output show, we need only nextState, so do '>> 1' right shift,
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int neighbourSum = findNeighbourSum(board, i, j);

                if (board[i][j] == 1) {
                    if (neighbourSum == 2 || neighbourSum == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (neighbourSum == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] =  board[i][j] >>1;
            }
        }
    }

    private  static int findNeighbourSum(int[][] board, int row, int column) {

        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {

                if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
                count = count + (board[i][j] & 1);

            }
        }

        //remove itself
        count = count - (board[row][column] & 1);

        return count;
    }

    public static void main(String args[]) {

        int[][] input = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(input);
    }
}