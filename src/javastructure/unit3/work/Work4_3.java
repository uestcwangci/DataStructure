package javastructure.unit3.work;

import javastructure.unit3.queue.IQueue;

public class Work4_3 {
    public static void main(String[] args) throws Exception {
        circleSqQueue circleSqQ = new circleSqQueue(10);
        System.out.println("是否为空：" + circleSqQ.isEmpty());
        for (int i = 0; i < 8; i++) {
            circleSqQ.offer(i);
        }
        circleSqQ.offer(99);
        circleSqQ.offer(99);
        circleSqQ.display();
        circleSqQ.poll();
        circleSqQ.poll();
        circleSqQ.poll();
        circleSqQ.poll();
        circleSqQ.display();
        circleSqQ.offer(-1);
        circleSqQ.offer(-2);
        circleSqQ.offer(-3);
        circleSqQ.offer(-4);
        circleSqQ.display();

        circleSqQ.clear();
        System.out.println("是否为空：" + circleSqQ.isEmpty());
        circleSqQ.display();
    }
}

class circleSqQueue implements IQueue {
    private boolean isFull;//false为空,true为满
    private int front;//指向首元素
    private int rear;//指向下一个存储元素
    private Object[] elem;

    public circleSqQueue(int maxSize) {
        this.elem = new Object[maxSize];
        this.isFull = false;
        this.front = this.rear = 0;
    }

    @Override
    public void clear() {
        isFull = false;
        front = rear = 0;
    }

    @Override
    public int length() {
        return (rear - front + elem.length) % elem.length;
    }

    @Override
    public boolean isEmpty() {
        return !isFull && front == rear;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        if (isFull && front == rear) {
            throw new Exception("队列已满");
        }
        elem[rear] = x;
        rear = (rear + 1) % elem.length;
        if (front == rear) {//如果入队后，队列已满
            isFull = true;
        }

    }

    @Override
    public Object poll() {
        if (!isFull && front == rear) {
            return null;
        }
        Object temp = elem[front];
        front = (front + 1) % elem.length;
        isFull = false;

        return temp;
    }

    public void display() {
        System.out.println("front:" + front);
        System.out.println("rear: " + rear);
        int count = (rear - front + elem.length) % elem.length;
        if (isFull)
            count = 10;
        for (int i = 0, j = front; i < count; i++, j++) {
            System.out.print(elem[(j + elem.length) % elem.length] + " ");
        }
        System.out.println();
    }

}
