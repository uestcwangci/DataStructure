package javastructure.unit2;

public class TwoWayNode {
    public Object data;
    public TwoWayNode next;
    public TwoWayNode last;

    public TwoWayNode() {
        this(null, null, null);
    }

    public TwoWayNode(Object data) {
        this.data = data;
        this.last = null;
        this.next = null;
    }

    public TwoWayNode(Object data, TwoWayNode next, TwoWayNode last) {
        this.data = data;
        this.next = next;
        this.last = last;
    }
}
