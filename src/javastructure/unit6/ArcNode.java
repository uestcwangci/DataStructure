package javastructure.unit6;

public class ArcNode {
    public int adjVex;//该弧所指向的顶点位置
    public int value;
    public ArcNode nextArc;//指向下一条弧

    public ArcNode() {
        this(-1, 0, null);
    }

    public ArcNode(int adjVex) {
        this.adjVex = adjVex;
        this.value = 0;
        this.nextArc = null;
    }

    public ArcNode(int adjVex, int value) {
        this.adjVex = adjVex;
        this.value = value;
        this.nextArc = null;
    }

    public ArcNode(int adjVex, int value, ArcNode nextArc) {
        this.adjVex = adjVex;
        this.value = value;
        this.nextArc = nextArc;
    }
}
