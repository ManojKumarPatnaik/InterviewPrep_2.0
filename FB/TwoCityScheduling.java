package FB;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/two-city-scheduling/

//efficient solution


class PQNode{

    int cost;
    int diff;
    boolean isCityA;
    int costA;
    int costB;
}




public class TwoCityScheduling {


    //EFFICINET SOLUTION

    public static int twoCityScheduleCost(int[][] costs) {
        Arrays.sort(costs, (cost1, cost2)->((cost1[0]-cost1[1])-((cost2[0]-cost2[1]))));
        int total=0;
        for(int i=0; i<costs.length; i++){
            if(i<costs.length/2) total+=costs[i][0];
            else total+=costs[i][1];
        }

        return total;

    }



    //IN-EFFICIENT SOLUTION
    static PriorityQueue<PQNode> a_minheap = new PriorityQueue<>((a,b) -> a.diff-b.diff);
    static PriorityQueue<PQNode> b_minheap = new PriorityQueue<>((a,b) -> a.diff-b.diff);

    public static int twoCitySchedCost(int[][] costs) {

        int cityASize = 0;
        int cityBSize = 0;

        for (int i = 0; i < costs.length; i++) {

            int cityACost = costs[i][0];
            int cityBCost = costs[i][1];
            PQNode node = new PQNode();
            node.costA = cityACost;
            node.costB = cityBCost;
            if (cityACost <= cityBCost) {
                node.cost = cityACost;
                node.diff = cityBCost - cityACost;
                node.isCityA = true;
                a_minheap.add(node);
                cityASize++;
            } else {
                node.cost = cityBCost;
                node.diff = cityACost - cityBCost;
                node.isCityA = false;
                b_minheap.add(node);
                cityBSize++;
            }
        }

        int n = costs.length / 2;
        if (cityASize > cityBSize) {
            int extraPerson = cityASize - n;
            modifyHeap(a_minheap, b_minheap, extraPerson);

        } else if (cityBSize > cityASize) {
            int extraPerson = cityBSize - n;
            modifyHeap(b_minheap, a_minheap, extraPerson);
        }

        int totalCost = 0;
        while (!a_minheap.isEmpty()) {
            totalCost += a_minheap.remove().cost;
        }

        while (!b_minheap.isEmpty()) {
            totalCost += b_minheap.remove().cost;
        }

        return totalCost;

    }

    private static void modifyHeap(PriorityQueue<PQNode> heapHigh,PriorityQueue<PQNode> heapLow, int extraPerson) {

        while (extraPerson > 0) {
            PQNode pq = heapHigh.peek();
            heapHigh.remove();
            if(pq.isCityA) {
                pq.cost = pq.costB;
            } else {
                pq.cost = pq.costA;

            }
            heapLow.add(pq);
            extraPerson--;
        }

    }

    public static void main(String args[]) {

        int[][] a = {{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        System.out.println(twoCitySchedCost(a));
    }
}

