package javastructure.unit3.queue;

import javastructure.unit3.Node;
//优先数越小，优先级越大
public class PriorityQueue implements IQueue {
    private Node front;
    private Node rear;

    public PriorityQueue() {
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
        if (p != null) {
            p = p.next;
            j++;
        }
        return j;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return front.data;
        }
        return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        PriorityQData pn = (PriorityQData) x;
        Node s = new Node(pn);
        if (isEmpty()) {
            front = rear = s;
        } else {
            Node p = front;
            Node q = front;
            while (p != null && pn.priority > ((PriorityQData) (p.data)).priority) {//优先数比原队列结点大，优先级低，后置
                q = p;//q为上一个结点
                p = p.next;
            }
            if (p == null) {//队尾
                rear.next = s;
                rear = s;
            } else if (p == front) {//优先级比队首还要高
                s.next = front;
                front = s;
            } else {
                q.next = s;
                s.next = p;
            }
        }
    }

    @Override
    public Object poll() {
        if (!isEmpty()) {
            Node p = front;
            front = front.next;
            return p.data;
        }
        return null;
    }

    public void display() {
        Node p = front;
        while (p != null) {
            PriorityQData pn = (PriorityQData) p.data;
            System.out.println(pn.elem + "\t" + pn.priority);
            p = p.next;
        }
    }
}
