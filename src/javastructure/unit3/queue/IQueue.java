package javastructure.unit3.queue;

public interface IQueue {
    void clear();
    int length();
    boolean isEmpty();
    Object peek();
    void offer(Object x) throws Exception;
    Object poll();
}
