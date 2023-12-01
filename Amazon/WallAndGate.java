package Amazon;

//https://www.youtube.com/watch?v=e69C6xhiSQE

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;
}

public class WallAndGate {


    public static void main(String args[]) {

        int[][] input = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        int[][] output = new int[input.length][input[0].length];
        Queue<Node> bfsQueue = new LinkedList<>();

        //fill the output matrix with -1 and 0
        for(int i=0;i<input.length;i++) {
            for(int j=0;j<input[0].length;j++) {
                if(input[i][j] == 0) {
                    Node n = new Node();
                    n.x = i;
                    n.y = j;
                    bfsQueue.add(n);
                }
            }
        }


        fillMatrix(input, bfsQueue);

        for(int i=0;i<input.length;i++) {
            for(int j=0;j<input[0].length;j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static void fillMatrix(int[][] input, Queue bfsQueue){

        while(!bfsQueue.isEmpty()) {

           Node n = (Node)bfsQueue.remove();
           int x = n.x;
           int y = n.y;


           //left
            if(y>0 && input[x][y-1] != -1 && input[x][y-1] != 0 && input[x][y-1] > input[x][y] + 1) {

                input[x][y-1] = input[x][y] + 1;
                Node temp = new Node();
                temp.x = x;
                temp.y = y-1;
                bfsQueue.add(temp);
            }

            //right
            if(y<input[0].length-1 && input[x][y+1] != -1 && input[x][y+1] != 0 && input[x][y+1] > input[x][y] + 1) {

                input[x][y+1] = input[x][y] + 1;
                Node temp = new Node();
                temp.x = x;
                temp.y = y+1;
                bfsQueue.add(temp);
            }
            //top
            if(x>0 && input[x-1][y] != -1 && input[x-1][y] != 0 && input[x-1][y] > input[x][y] + 1) {

                input[x-1][y] = input[x][y] + 1;
                Node temp = new Node();
                temp.x = x-1;
                temp.y = y;
                bfsQueue.add(temp);
            }
            //bottom
            if(x<input.length-1 && input[x+1][y] != -1 && input[x+1][y] != 0 && input[x+1][y] > input[x][y] + 1) {

                input[x+1][y] = input[x][y] + 1;
                Node temp = new Node();
                temp.x = x+1;
                temp.y = y;
                bfsQueue.add(temp);
            }
        }

    }

    //dfs approach
//https://www.youtube.com/watch?v=Pj9378ZsCh4&t=25s




}
