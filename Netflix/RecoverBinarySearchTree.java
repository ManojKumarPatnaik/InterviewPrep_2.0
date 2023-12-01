package Netflix;


public class RecoverBinarySearchTree {

    TreeNode prev = null;
    TreeNode node1 = null;
    TreeNode node2 = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(node1, node2);
    }

    private void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (node1 == null) {
                node1 = prev;
            }
            node2 = root;
        }
        prev = root;
        inorder(root.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

