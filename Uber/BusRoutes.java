package Uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/bus-routes/
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int len = routes.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (map.containsKey(routes[i][j])) {
                    List<Integer> current = map.get(routes[i][j]);
                    current.add(i);
                    map.put(routes[i][j], current);
                } else {
                    List<Integer> current = new LinkedList<>();
                    current.add(i);
                    map.put(routes[i][j], current);
                }
            }
        }
        Set<Integer> buses = new HashSet<>();
        Set<Integer> stops = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.offer(source);
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int stop = q.poll();
                if (stop == target) return moves;
                for (int route : map.get(stop)) {
                    if (buses.contains(route)) continue;
                    buses.add(route);
                    for (int neighbour : routes[route]) {
                        if (stops.contains(neighbour)) continue;
                        stops.add(neighbour);
                        q.offer(neighbour);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    public static void main(String args[]) {

        int[][]routes = {{1,2,7},{3,6,7}};
        int source = 1;
        int target = 6;

        BusRoutes busRoutes = new BusRoutes();
        System.out.println(busRoutes.numBusesToDestination(routes,source,target));
    }
}

