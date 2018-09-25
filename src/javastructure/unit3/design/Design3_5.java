package javastructure.unit3.design;

import javastructure.unit3.Node;
import javastructure.unit3.queue.IQueue;

public class Design3_5 {
    public static void main(String[] args) throws Exception {
        circleLinkQueue circleLQue = new circleLinkQueue();
        System.out.println(circleLQue.isEmpty());
        for (int i = 0; i < 5; i++) {
            circleLQue.offer(i);
        }
        circleLQue.display();
        circleLQue.clear();
        for (int i = 5; i < 10; i++) {
            circleLQue.offer(i);
        }
        circleLQue.display();
        circleLQue.poll();
        circleLQue.poll();
        circleLQue.display();
    }
}

class circleLinkQueue implements IQueue {
    private Node rear;
    private Node head;

    public circleLinkQueue() {
        this.head = new Node();
        rear = head;
    }

    @Override
    public void clear() {
        this.head.data = null;
        this.head.next = head;
        rear = head;
    }

    @Override
    public int length() {
        int j = 0;
        Node p = head.next;
        while (p != head) {
            p = p.next;
            j++;
        }
        return j;
    }

    @Override
    public boolean isEmpty() {
        return rear == head;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        Node s = new Node(x);
        rear.next = s;
        rear = s;
        rear.next = head;

    }

    @Override
    public Object poll() {
        if (rear != head) {
            Node p = head.next;
            head.next = head.next.next;
            return p.data;
        }
        return null;
    }

    public void display() {
        Node p = head.next;
        while (p != head) {
            System.out.print(p.data.toString() + " ");
            p = p.next;
        }
        System.out.println();
    }
}
