package javastructure.unit3;

import javastructure.unit3.stack.LinkStack;

public class testDemo {
    public static void main(String[] args) throws Exception {
        LinkStack stack = new LinkStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.dispaly();
        stack.pop();
        stack.dispaly();

    }
}
