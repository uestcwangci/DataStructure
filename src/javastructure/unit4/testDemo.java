package javastructure.unit4;

import java.util.Arrays;

public class testDemo {
    public static void main(String[] args) {
        String str = "hello";
        char[] abc = new char[]{'a', 'b', 'c'};
        SeqString seqStr = new SeqString(str);
        SeqString seqStr1 = new SeqString(abc);
        str = "world";
        char[] bcd = {'e', 'f', 'g'};
        abc = bcd;
        System.out.println(Arrays.toString(abc));
        seqStr.display();
        seqStr1.display();
    }
}
