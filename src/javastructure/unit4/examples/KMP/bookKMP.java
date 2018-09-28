package javastructure.unit4.examples.KMP;

import java.util.Arrays;

public class bookKMP {
    public static void main(String[] args) {
        bookKMP kmp = new bookKMP();
        System.out.println(Arrays.toString(kmp.findNext("bbbbc")));

    }

    private int[] findNext(String str) {
        int[] next = new int[str.length()];
        int j = 1;
        int k = 0;
        next[0] = -1;
        next[1] = 0;
        while (j < str.length() - 1) {
            if (str.charAt(j) == str.charAt(k)) {         //匹配
                next[++j] = ++k;
            } else if (k == 0) {                          //不匹配
                next[++j] = 0;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
