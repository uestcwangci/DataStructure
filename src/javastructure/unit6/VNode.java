package javastructure.unit6;

public class VNode {
    public Object data;
    public ArcNode firstArc;
    public int visited;

    public VNode() {
        this(null, null, 0);
    }

    public VNode(Object data) {
        this(data, null, 0);
    }

    public VNode(Object data, ArcNode firstArc) {
        this.data = data;
        this.firstArc = firstArc;
        this.visited = 0;
    }
    public VNode(Object data, ArcNode firstArc, int visited) {
        this.data = data;
        this.firstArc = firstArc;
        this.visited = 0;
    }
}
