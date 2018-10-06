package javastructure.unit4.designs;

import javastructure.unit4.SeqString;

import java.util.Arrays;

public class SeqStringTest {
    public static void main(String[] args) throws Exception {
        SeqString seqString = new SeqString("helloa");
        seqString.concat(new SeqString(" woarld"));
        System.out.println(seqString.length());
        System.out.println(seqString.charAt(8));
        System.out.println(Arrays.toString(seqString.indexOfKMP(new SeqString("oa"), 0)));
        System.out.println(seqString.indexOf(new SeqString("oa"), 0));
        seqString.display();
        SeqString newSeqStr = seqString.replace(0, new SeqString("oa"), new SeqString("yy"));
        System.out.println("把oa替换为yy");
        newSeqStr.display();
        seqString.reverse();
        System.out.println("反转");
        seqString.display();
        seqString.reverse();
        System.out.println("删除字符a");
        seqString.deleteallchar('a').display();
        System.out.println("统计wo个数：");
        System.out.println(seqString.stringcount(new SeqString("wo")));
    }
}
