public class Tree {

    Integer data;
    Tree leftNode;
    Tree rightNode;

    public Tree(Integer data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Tree(Integer data, Tree leftNode, Tree rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
