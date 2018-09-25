package javastructure.unit3.design;

import javastructure.unit3.stack.LinkStack;

public class Design3_2 {
    public static void main(String[] args) throws Exception {
        String str1 = "hello";
        String str2 = "abcba";
        String str3 = "aabb";
        String str4 = "abba";
        isEcho(str1);
        isEcho(str2);
        isEcho(str3);
        isEcho(str4);
    }


    private static void isEcho(String str1) throws Exception {
        LinkStack S = new LinkStack();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            S.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!S.isEmpty()) {
            sb.append((char) S.pop());
        }
        String str2 = sb.toString();
        if (str1.equals(str2)) {
            System.out.println(str1 + "是回文");
        } else {
            System.out.println(str1 + "不是回文");
        }
    }
}

