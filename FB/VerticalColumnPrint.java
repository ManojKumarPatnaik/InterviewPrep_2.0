package FB;

//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

//https://leetcode.com/discuss/interview-question/1615455/Meta(Facebook)-or-Phone-Interview-or-Column-Tree

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

           1
        /    \
       2      3
      / \   /   \
     4   5  6   7
               /  \
              8   9

 */
public class VerticalColumnPrint {

    static class Node
    {
        int key;
        Node left;
        Node right;

        // Constructor
        Node(int data)
        {
            key = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        TreeMap<Integer, List<Integer>> outputValues = new TreeMap<>();
        printVerticalOrder(root, 0, outputValues);

       for(Map.Entry<Integer, List<Integer>> entry: outputValues.entrySet()) {

           List<Integer> vals = entry.getValue();
           for(Integer x : vals) {
               System.out.print(x);
           }
           System.out.println();
       }
    }

    private static void printVerticalOrder(Node root, int distanceFromRoot,
                                           TreeMap<Integer, List<Integer>> outputValues) {

        if(root == null) {
            return;
        }

        if(outputValues.containsKey(distanceFromRoot)) {
            List<Integer> values = outputValues.get(distanceFromRoot);
            values.add(root.key);
            outputValues.put(distanceFromRoot, values);

        } else {
            List<Integer> values = new ArrayList<>();
            values.add(root.key);
            outputValues.put(distanceFromRoot, values);
        }

        printVerticalOrder(root.left, distanceFromRoot-1,  outputValues);
        printVerticalOrder(root.right, distanceFromRoot+1,  outputValues);
    }
}
