package javastructure.unit4.examples.KMP;

import javastructure.unit4.IString;
import javastructure.unit4.SeqString;

import java.util.Arrays;

public class bookKMP {
    public static void main(String[] args) throws Exception {
        SeqString seqString = new SeqString("bbbbc");
        System.out.println(Arrays.toString(findNext(seqString)));
        System.out.println(Arrays.toString(findNextVal(seqString)));

    }

    public static int[] findNext(IString str) throws Exception {
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

    public static int[] findNextVal(IString str) throws Exception {
        int[] nextval = new int[str.length()];
        int j = 1;
        int k = 0;
        nextval[0] = -1;
//        nextval[1] = 0;
        while (j < str.length() - 1) {
            if (k == -1 || str.charAt(j) == str.charAt(k)) {//匹配或者没有一个匹配
                j++;
                k++;
                if (str.charAt(j) != str.charAt(k)) {
                    nextval[j] = k;
                } else {
                    nextval[j] = nextval[k];
                }
            } else {//不匹配
                k = nextval[k];
            }
        }
        return nextval;
    }
}
