package javastructure.unit3;

public class SqStack implements IStack{
    private Object[] stackElem;
    private int top;

    public SqStack(int maxSize) {
        this.top = 0;
        stackElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        this.top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackElem[top - 1];
        }
    }

    @Override
    public void push(Object x) throws Exception {
        if (top == stackElem.length) {
            throw new Exception("栈已满");
        } else {
            stackElem[top++] = x;
        }

    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return stackElem[--top];
    }

    public void display() { //从栈顶向栈底输出
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stackElem[i] + " ");
        }
        System.out.println();
    }
}
