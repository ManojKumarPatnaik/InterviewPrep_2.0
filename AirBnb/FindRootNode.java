package AirBnb;

import java.io.*;
import java.math.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//https://leetcode.com/discuss/interview-question/1315351/airbnb-online-test-may-2021
public class FindRootNode {

    private static int findRootGraph(List<List<Integer>> nodes) {

        Map<Integer, List<Integer>> parentChildRel = new HashMap<>();
        Map<Integer, Integer> childParentRel = new HashMap<>();
        Map<Integer, Boolean> nodeVisited = new HashMap<>();
        Integer rootNode = -1;

        for (List<Integer> node : nodes) {

            int nodeValue = node.get(0);
            int nodeLeftValue = node.get(1);
            int nodeRightValue = node.get(2);


            if (!parentChildRel.containsKey(nodeValue)) {
                parentChildRel.put(nodeValue, new ArrayList<>());
                nodeVisited.put(nodeValue, false);
            }

            if (nodeLeftValue != -1) {

                //one child has more than 1 parent return -1
                if (childParentRel.containsKey(nodeLeftValue)) {
                    return -1;
                }
                childParentRel.put(nodeLeftValue, nodeValue);
                parentChildRel.get(nodeValue).add(nodeLeftValue);

            }


            if (nodeRightValue != -1) {
                //one child has more than 1 parent return -1
                if (childParentRel.containsKey(nodeRightValue)) {
                    return -1;
                }
                childParentRel.put(nodeRightValue, nodeValue);
                parentChildRel.get(nodeValue).add(nodeRightValue);
            }
        }

        //now check if all the child nodes are there in the parent list or not.
        //this is needed to cover the usecase that each node should be in array node

        Set<Integer> childNodes = childParentRel.keySet();
        Set<Integer> parentNodes = parentChildRel.keySet();
        for (Integer childNode : childNodes) {

            if (parentNodes.contains(childNode)) {
                continue;
            }
            return -1;
        }


        //find the root node, and if there are more than 1 root node, return -1
        for (Integer parentNode : parentNodes) {

            if (childNodes.contains(parentNode)) {
                continue;
            }

            if (rootNode == -1) {
                rootNode = parentNode;
            } else {
                return -1;
            }
        }


        //now we check if traversing from this root node will cover all the nodes or not
        traverse(rootNode, nodeVisited, parentChildRel);

        for (Map.Entry<Integer, Boolean> entrySet : nodeVisited.entrySet()) {

            Boolean isVisited = entrySet.getValue();
            if (isVisited == false) {
                return -1;
            }
        }


        return rootNode;
    }

    private static void traverse(Integer rootNode, Map<Integer, Boolean> nodeVisited, Map<Integer, List<Integer>> parentChildRel) {

        //if node is already visited return
        if (nodeVisited.get(rootNode)) {
            return;
        }

        nodeVisited.put(rootNode, true);
        for (Integer childNode : parentChildRel.get(rootNode)) {
            traverse(childNode, nodeVisited, parentChildRel);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/Users/shrajain/Desktop/airbnb_input_failure.txt"));

        int nodesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int nodesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> nodes = new ArrayList<>();

        IntStream.range(0, nodesRows).forEach(i -> {
            try {
                nodes.add(
                        Stream.of(bufferedReader.readLine().replaceAll(",", " ").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = findRootGraph(nodes);
        System.out.print(result);
        bufferedReader.close();
    }
}
