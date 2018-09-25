package javastructure.unit3.design;

import javastructure.unit3.stack.SqStack;

public class Design3_1 {
    public static void main(String[] args) throws Exception {
        int[] x = new int[10];
        for (int i = 0; i < 10; i++) {
            x[i] = i;
        }
        reverse(x);
    }

    private static void reverse(int[] x) throws Exception {
        SqStack S = new SqStack(x.length);
        System.out.println("逆置前：");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
            S.push(x[i]);
        }
        System.out.println("\n逆置后：");
        S.display();
    }
}
