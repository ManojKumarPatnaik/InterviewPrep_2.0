import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//https://www.youtube.com/watch?v=XB4MIexjvY0
//complexity 0(N^2)

public class DijkstrasAlgo {

    class Node {

        String name = null;
        Integer costFromStartNode = Integer.MAX_VALUE;
        String pathFromStartNode = null;
        List<Node> directlyConnectedNodes = new ArrayList<>();
        Map<Node, Integer> directlyConnectedNodesCost = new HashMap<>();

        Node(String name) {
            this.name = name;
        }

        void addName(String name) {
            this.name = name;
        }

        void addDirectlyConnectedNodes(Node connectedNode, Integer cost) {
            directlyConnectedNodes.add(connectedNode);
            directlyConnectedNodesCost.put(connectedNode, cost);
        }

        List<Node> getDirectlyConnectedNodes() {
            return directlyConnectedNodes;
        }
    }

    class Graph {

        private List<Node> nodes = new ArrayList<>();

        public void addNode(Node node) {
            nodes.add(node);
        }

        public List<Node> getGraphNodes() {
            return nodes;
        }
    }

    private Map<Node, Integer> findShortestPath(Node startingNode, Graph graph) {

        Set<Node> settledNode = new HashSet<>();

        //update the outputMap with all other nodes and distance mark as Infinity
        Map<Node, Integer> output = new HashMap<>();
        for (Node n : graph.getGraphNodes()) {
            if (!n.name.equals(startingNode.name)) {
                output.put(n, Integer.MAX_VALUE);
            } else {
                output.put(n, 0);
            }
        }


        //create a min priority queue based on the cost
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.costFromStartNode - b.costFromStartNode;
        });

        //to start add all the connected nodes of starting Node in PQ
        startingNode.costFromStartNode = 0;
        startingNode.pathFromStartNode = startingNode.name;
        pq.add(startingNode);

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            settledNode.add(node);
            output.put(node, node.costFromStartNode);

            //add all the adjacent nodes in the queue of this node
            List<Node> adjacentNodes = node.getDirectlyConnectedNodes();
            for(Node adjacentNode : adjacentNodes) {
                if(settledNode.contains(adjacentNode)) continue;
                Integer newValue =  node.costFromStartNode + node.directlyConnectedNodesCost.get(adjacentNode);
                if(adjacentNode.costFromStartNode > newValue) {
                    adjacentNode.costFromStartNode = newValue;
                    adjacentNode.pathFromStartNode = node.pathFromStartNode + adjacentNode.name;
                    pq.add(adjacentNode);
                }
            }
        }

        return output;
    }

    private Graph createGraph() {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");


        //A->B = 10 and A->C = 15
        nodeA.addDirectlyConnectedNodes(nodeB, 10);
        nodeA.addDirectlyConnectedNodes(nodeC, 15);

        //B->F = 15 and B->D = 12
        nodeB.addDirectlyConnectedNodes(nodeF, 15);
        nodeB.addDirectlyConnectedNodes(nodeD, 12);

        //C->E = 10
        nodeC.addDirectlyConnectedNodes(nodeE, 10);

        //D->F = 1 and D->E = 2
        nodeD.addDirectlyConnectedNodes(nodeF, 1);
        nodeD.addDirectlyConnectedNodes(nodeE, 2);


        //F->E = 5
        nodeF.addDirectlyConnectedNodes(nodeE, 5);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        return graph;
    }

    public static void main(String args[]) {

        DijkstrasAlgo obj = new DijkstrasAlgo();
        Graph graph = obj.createGraph();
        System.out.println("startnode: " + graph.getGraphNodes().get(0).name);
        Map<Node, Integer> output = obj.findShortestPath(graph.getGraphNodes().get(0), graph);

        for(Map.Entry<Node, Integer> value : output.entrySet()) {

            Node node = value.getKey();
            Integer nodeCost = value.getValue();
            System.out.println(node.name + " : " + nodeCost + " : " + node.pathFromStartNode);
        }
    }
}
