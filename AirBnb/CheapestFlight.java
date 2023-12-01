package AirBnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//dfsdf
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
class CheapestFlight {

    int output = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Node>> srcDestGraph = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            Node x = new Node();
            x.city = flights[i][1];
            x.cost = flights[i][2];
            List<Node> flightDetails = srcDestGraph.getOrDefault(source, new ArrayList<>());
            flightDetails.add(x);
            srcDestGraph.put(source, flightDetails);
        }
        List<Integer> visitedPath = new ArrayList<>();
        findCheapPrice(srcDestGraph, src, dst, k, 0, visitedPath);
        return output == Integer.MAX_VALUE ? -1 : output;
    }

    public void findCheapPrice(Map<Integer, List<Node>> srcDestGraph, int src, int dst, int k,
                               int tempPrice, List<Integer> visitedPath) {

        List<Node> connectedCities = srcDestGraph.get(src);
        if (connectedCities == null) {
            return;
        }
        visitedPath.add(src);
        for (Node n : connectedCities) {
            if (n.city == dst) {
                if ((tempPrice + n.cost) < output) {
                    output = tempPrice + n.cost;
                }
            } else {
                if (k > 0 && !visitedPath.contains(n.city)) {
                    findCheapPrice(srcDestGraph, n.city, dst, k - 1, tempPrice + n.cost, visitedPath);
                }
            }
        }
        visitedPath.remove(visitedPath.size() - 1);
    }

    class Node {

        Integer city;
        Integer cost;
    }

    public int findCheapestPriceEfficient(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }

    public static void main(String args[]) {
        int n = 5;
        int[][] arr = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        CheapestFlight obj = new CheapestFlight();
        System.out.println(obj.findCheapestPrice(n, arr, src, dst, k));


    }
}