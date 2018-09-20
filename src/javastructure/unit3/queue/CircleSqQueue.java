package javastructure.unit3.queue;

public class CircleSqQueue implements IQueue {
    private Object[] queueElem;
    private int front;
    private int rear;

    public CircleSqQueue() {
        int defaultSize = 50;
        this.queueElem = new Object[50];
        this.front = 0;
        this.rear = 0;
    }

    public CircleSqQueue(int maxSize) {
        this.queueElem = new Object[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public int length() {
        return (rear + queueElem.length - front) % queueElem.length;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return queueElem[front];
    }
    //入队
    @Override
    public void offer(Object x) throws Exception {
        if (front == (rear + 1) % queueElem.length) {
            throw new Exception("队列已满");
        }
        queueElem[rear] = x;
        rear = (rear + 1) % queueElem.length;
    }
    //出队
    @Override
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        Object temp = queueElem[front];
        front = (front + 1) % queueElem.length;
        return temp;
    }

    private void display() {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % queueElem.length) {
                System.out.print(queueElem[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("此队列无元素");
        }
    }
}
