//Question : Write a program to traverse a tree [Inorder traversal]

public class TreeInorderTraversal {

    public static void inorderTraversal( Tree rootNode) {

        if(rootNode == null) {
            return;
        }

        inorderTraversal(rootNode.leftNode);
        System.out.print(rootNode.data);
        inorderTraversal(rootNode.rightNode);
    }
}
