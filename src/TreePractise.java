public class TreePractise {

    public static void main(String args[]) {

        Tree rootNode = createTree();
        TreeInorderTraversal.inorderTraversal(rootNode);

    }

    private static Tree createTree() {

        Integer[] treeValues = new Integer[]{1,2,3,4,5,6,7};

        int initialIndex = 0;
        Tree rootNode = new Tree(treeValues[initialIndex]);
        fillTreesWithValues(rootNode, initialIndex, treeValues);
        return rootNode;
    }

    private static void fillTreesWithValues(Tree node, int nodeIndex, Integer[] treeValues) {

        int leftChildIndex = nodeIndex * 2 + 1;
        int rightChildIndex = nodeIndex * 2 + 2;
        Tree leftNode = null;
        Tree rightNode = null;

        if (leftChildIndex < treeValues.length &&
                treeValues[leftChildIndex] != null) {
            leftNode = new Tree(treeValues[leftChildIndex]);
            node.leftNode = leftNode;
            fillTreesWithValues(leftNode, leftChildIndex, treeValues);
        }

        if (rightChildIndex < treeValues.length  &&
                treeValues[rightChildIndex] != null) {
            rightNode = new Tree(treeValues[rightChildIndex]);
            node.rightNode = rightNode;
            fillTreesWithValues(rightNode, rightChildIndex, treeValues);
        }
    }

    private static void inorderTraversal(Tree rootNode) {

        if(rootNode == null) {
            return;
        }

        inorderTraversal(rootNode.leftNode);
        System.out.println(rootNode.data);
        inorderTraversal(rootNode.rightNode);
    }
}
