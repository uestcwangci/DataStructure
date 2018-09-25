package javastructure.unit3.work;

import javastructure.unit3.stack.LinkStack;

public class Work4_4 {
    public static void main(String[] args) throws Exception {
        Work4_4 wk = new Work4_4();
        wk.DtoB(5);
        wk.DtoB(6);
        wk.DtoB(11);
        wk.DtoB(75);
    }

    public void DtoB(int decimal) throws Exception {
        //十进制转二进制，用十进制的数一直除以2，然后从后向前取余数
        LinkStack L = new LinkStack();//存放余数
        System.out.print("十进制为：");
        System.out.println(decimal);
        while (decimal != 0) {
            L.push(decimal % 2);
            decimal /= 2;
        }
        System.out.print("二进制为：");
        L.dispaly();
        System.out.println();
    }
}
