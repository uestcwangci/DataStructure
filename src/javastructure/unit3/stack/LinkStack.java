package javastructure.unit3.stack;

import javastructure.unit2.Node;

public class LinkStack implements IStack {
    private Node top;
    //不带头结点
    public LinkStack() {
        top = null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        Node p = top;
        int j = 0;
        while (p != null) {
            p = p.next;
            j++;
        }
        return j;
    }
    //取栈顶元素并返回其值
    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }
    //入栈
    @Override
    public void push(Object x) throws Exception {
        Node s = new Node(x);
        s.next = top;
        top = s;
    }
    //出栈
    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Node p = top;
        top = p.next;
        return p.data;
    }

    public void dispaly() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}
