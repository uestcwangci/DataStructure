package javastructure.unit5;

public class CSTreeNode {
    //左子右兄二叉树
    public Object data;
    public CSTreeNode lChild, rBro;

    public CSTreeNode() {
        this(null);
    }

    public CSTreeNode(Object data) {
        this.data = data;
        this.lChild = null;
        this.rBro = null;
    }

    public CSTreeNode(Object data, CSTreeNode lChild, CSTreeNode rBro) {
        this.data = data;
        this.lChild = lChild;
        this.rBro = rBro;
    }
}
