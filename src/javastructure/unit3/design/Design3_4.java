package javastructure.unit3.design;

import javafx.beans.binding.ObjectBinding;
import javastructure.unit3.queue.IQueue;

public class Design3_4 {
    public static void main(String[] args) throws Exception {
        circleSqQueue circleQ = new circleSqQueue(10);
        for (int i = 0; i < 8; i++) {
            circleQ.offer(i);
        }
        circleQ.display();
        circleQ.offer(99);
        circleQ.offer(99);
        circleQ.display();
        circleQ.poll();
        circleQ.poll();
        circleQ.poll();
        circleQ.poll();
        circleQ.display();
        circleQ.offer(-5);
        circleQ.offer(-6);
        circleQ.offer(-7);
        circleQ.offer(-8);
        circleQ.display();

    }
}
class circleSqQueue implements IQueue {
    private int front;//指向首元素
    private int rear; //指向尾元素
    private int count;//用于计数，判空/判满
    private Object[] elems;

    public circleSqQueue(int maxSize) {
        this.elems = new Object[maxSize];
        this.count = this.front = this.rear = 0;
    }

    @Override
    public void clear() {
        this.count = this.front = this.rear = 0;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        if (count == elems.length) {
            throw new Exception("队列已满");
        }
        if (count == 0) {//队列为空时插入
            elems[front] = elems[rear] = x;
            count++;
        } else {
            rear = (rear + 1) % elems.length;
            elems[rear] = x;
            count++;
        }

    }

    @Override
    public Object poll() {
        if (count != 0) {
            front = (front + 1) % elems.length;
            count--;
        }
        return null;
    }

    public void display() {
        System.out.println("front: " + front);
        System.out.println("rear:  " + rear);
        System.out.println("count: " + count);
        for (int i = front, j = 0; j < count; i++, j++) {
            System.out.print(elems[i % elems.length] + " ");
        }
        System.out.println();

    }
}

