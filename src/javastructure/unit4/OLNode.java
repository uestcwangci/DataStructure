package javastructure.unit4;

public class OLNode {
    public int row, col;
    public int e;
    public OLNode right;
    public OLNode down;

    public OLNode() {
        this(0, 0, 0);
    }

    public OLNode(int row, int col, int e) {
        this.row = row;
        this.col = col;
        this.e = e;
        this.right = null;
        this.down = null;
    }
}
