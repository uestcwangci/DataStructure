package javastructure.unit3.queue;
import javastructure.unit3.Node;

import javax.print.attribute.standard.NumberUp;

public class LinkQueue implements IQueue {
    private Node front;
    private Node rear;

    public LinkQueue() {
        this.front = this.rear = null;
    }

    @Override
    public void clear() {
        this.front = this.rear = null;
    }

    @Override
    public int length() {
        int j = 0;
        Node p = front;
        while (p != null) {
            j++;
            p = p.next;
        }
        return j;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void offer(Object x) throws Exception {

    }

    @Override
    public Object poll() {
        return null;
    }
}
