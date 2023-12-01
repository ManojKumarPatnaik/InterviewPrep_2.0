import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/is-graph-bipartite/

a graph is bipartie, if adjacent nodes are of different colors (or not in one group)

 */

class GraphIsBipartieOrNot {

    private static int colorA = 1;
    private static int colorB = 2;
    private static int noColor = 0;

    public boolean isBipartite(int[][] graph) {

        int[] twoColorArray = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        while(anyNodeLeftForWhichColorIsNotSet(twoColorArray))  {
            int startingNode = findTheNextGraphPointToStart(twoColorArray);
            if(startingNode == -1) {
                break;
            }
            queue.add(startingNode);
            twoColorArray[startingNode] = colorA;
            while(!queue.isEmpty()) {

                int node = queue.poll();
                int colorCanBeUsed = twoColorArray[node] == colorA ? colorB : colorA;
                int[] connectedNodes = graph[node];
                for(int adjacentNode : connectedNodes) {
                    if(twoColorArray[adjacentNode] == noColor) {
                        queue.add(adjacentNode);
                        twoColorArray[adjacentNode] = colorCanBeUsed;
                    } else {

                        if(twoColorArray[adjacentNode] != colorCanBeUsed) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }

    private boolean anyNodeLeftForWhichColorIsNotSet(int[] twoColorArray) {

        for(int nodeColor: twoColorArray) {
            if(nodeColor == noColor) {
                return true;
            }
        }
        return false;
    }

    private int findTheNextGraphPointToStart(int[] twoColorArray) {

        for(int i=0; i<twoColorArray.length; i++) {
            if(twoColorArray[i] == noColor) {
                return i;
            }
        }

        return -1;
    }

}