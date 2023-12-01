import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/minimum-height-trees/  : solution is given in leetcode itself, read it its good
Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
Return a list of all MHTs' root labels. You can return the answer in any order.
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

similar solution but with queue: https://leetcode.com/problems/minimum-height-trees/discuss/1393677/Java-BFS-Solution-from-leaves-to-center

 */
public class GraphMinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // base cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        //construct a graph - adjacent list graph
        ArrayList<Set<Integer>> graph = new ArrayList<>();

        //initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        //fill it up
        for (int[] edge : edges) {

            int vertexStart = edge[0];
            int vertexEnd = edge[1];

            graph.get(vertexStart).add(vertexEnd);
            graph.get(vertexEnd).add(vertexStart);
        }

        //take out all the 1st set of leaf nodes
        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 1)
                leafNodes.add(i);


        int remainingNode = n;
        while (remainingNode > 2) {

            remainingNode = remainingNode - leafNodes.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            //remove the leafnodes from the graph
            for (Integer leafNode : leafNodes) {

                Integer parent = graph.get(leafNode).iterator().next();
                graph.get(parent).remove(leafNode);
                if (graph.get(parent).size() == 1) {
                    newLeaves.add(parent);
                }

            }

            leafNodes = newLeaves;

        }

        return leafNodes;

    }
}

/*

another way of creating the graph

its, graph is an array of List of Integers and
degree[] hold the number of edges from particular node

  private void buildGraph(List<Integer>[] graph, int[] degrees, int[][] edges) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            degrees[u]++;
            degrees[v]++;
        }
    }
 */
