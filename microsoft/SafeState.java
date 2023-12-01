package microsoft;

//https://leetcode.com/problems/find-eventual-safe-states/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class SafeState {

    private static Integer WHITE = 0;
    private static Integer GREY = 1;
    private static Integer BLACK = 2;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, Integer> nodesState = new LinkedHashMap<>();
        for (int i = 0; i < graph.length; i++) {
            nodesState.put(i, WHITE);
        }
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, nodesState)) {
                output.add(i);
            }
        }
        return output;
    }

    private boolean dfs(int[][] graph, int node, Map<Integer, Integer> nodesState) {

        if (nodesState.get(node) == GREY) { return false; }

        if (nodesState.get(node) == BLACK) { return true; }

        nodesState.put(node, GREY);
        for (int neighbour : graph[node]) {
            if (nodesState.get(neighbour) == WHITE) {
                boolean pathExist = dfs(graph, neighbour, nodesState);
                if (pathExist == false) {
                    return false;
                }
            } else if (nodesState.get(neighbour) == GREY) {
                return false;
            }
        }

        nodesState.put(node, BLACK);
        return true;
    }


    //not efficient
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        Map<Integer,Boolean> nodesGood = new LinkedHashMap<>();
        for(int i=0; i< graph.length; i++) {
            nodesGood.put(i,true);
        }

        for(int i=0; i< graph.length; i++) {
            if(nodesGood.get(i)) {
                dfs2(graph, i, nodesGood, new ArrayList<>());
            }
        }

        List<Integer> output = new ArrayList<>();
        for(Map.Entry<Integer,Boolean> node: nodesGood.entrySet()) {
            if(node.getValue()) {
                output.add(node.getKey());
            }
        }
        return output;
    }

    private void dfs2(int[][] graph, int node, Map<Integer, Boolean> nodesState, List<Integer> alreadyVisited)
    {

        if (alreadyVisited.contains(node) || nodesState.get(node) == false) {
            nodesState.put(node, false);
            for (Integer visitedNode : alreadyVisited) {
                nodesState.put(visitedNode, false);
            }
            return;
        }

        alreadyVisited.add(node);
        for (int neighbour : graph[node]) {
            dfs2(graph, neighbour, nodesState, alreadyVisited);
        }
        if (!alreadyVisited.isEmpty()) {
            alreadyVisited.remove((Integer) node);
        }
    }

    public static void main(String args[]) {

        SafeState obj = new SafeState();
        int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        int[][] graph2 = {{1, 2}, {0, 2}, {}};
        int[][] graph3 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        List<Integer> output = obj.eventualSafeNodes(graph2);
        for (Integer val : output) {
            System.out.println(val);
        }
    }
}