package javastructure.unit6;

public class ArcNode {
    public int adjVex;
    public int value;
    private ArcNode nextArc;

    public ArcNode() {
        this(-1, 0, null);
    }

    public ArcNode(int adjVex) {
        this.adjVex = adjVex;
        this.value = 0;
        this.nextArc = null;
    }

    public ArcNode(int adjVex, int value, ArcNode nextArc) {
        this.adjVex = adjVex;
        this.value = value;
        this.nextArc = nextArc;
    }
}
