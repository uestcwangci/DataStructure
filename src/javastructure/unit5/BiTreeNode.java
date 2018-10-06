package javastructure.unit5;


public class BiTreeNode {
    public Object data;
    public BiTreeNode lChild, rChild;

    public BiTreeNode() {
        this(null, null, null);
    }

    public BiTreeNode(Object data, BiTreeNode lChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = null;
    }

    public BiTreeNode(Object data) {
        this(data, null, null);
    }

    public BiTreeNode(Object data, BiTreeNode lChild, BiTreeNode rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }
}
