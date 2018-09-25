package javastructure.unit3.queue.example;

import javastructure.unit3.queue.PriorityQData;
import javastructure.unit3.queue.PriorityQueue;

public class Example3_6 {
    public static void main(String[] args) throws Exception {
        PriorityQueue pq = new PriorityQueue();
        System.out.println("线程 优先级");
        pq.offer(new PriorityQData(11, 2));
        pq.offer(new PriorityQData(52, 3));
        pq.offer(new PriorityQData(68, 1));
        pq.offer(new PriorityQData(24, 5));
        pq.offer(new PriorityQData(15, 5));
        pq.offer(new PriorityQData(77, 4));
        pq.display();
    }
}
