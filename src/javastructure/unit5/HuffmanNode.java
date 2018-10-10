package javastructure.unit5;

public class HuffmanNode {
    public int weight;
    public int flag;
    public HuffmanNode parent, lChird, rChird;

    public HuffmanNode() {
        this(0);
    }

    public HuffmanNode(int weight) {
        this.weight = weight;
        flag = 0;
        parent = lChird = rChird = null;
    }
}
