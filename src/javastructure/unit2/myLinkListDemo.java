package javastructure.unit2;

import java.util.Scanner;

public class myLinkListDemo {
    public static void main(String[] args) {
//        ex2_3();
        ex2_4();
    }

    private static void ex2_3() {
        LinkList list = new LinkList();
        for (int i = 0; i < 10; i++) {
            try {
                list.insert(i, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("输入i的值：");
        int i = new Scanner(System.in).nextInt();
        System.out.println("第" + i + "的前驱为：");
        if (i <= 0 || i > list.length()) {
            System.out.println("不存在");
        } else {
            try {
                System.out.println(list.get(i - 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void ex2_4() {
        LinkList list = new LinkList();
        for (int i = 0; i < 20; i++) {
            try {
                list.insert(i, (int)(Math.random()*10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("去重前的列表为:");
        list.display();
        try {
            removeRepeatElem(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n去重后的列表为:");
        list.display();


    }

    private static void removeRepeatElem(LinkList list) throws Exception{
        Node p = list.head.next;
        while (p != null) {
            Node n = p.next;
            int j = list.indexOf(p.data);
            while (n != null) {
                if (p.data.equals(n.data)) {
                    list.remove(j + 1);
                } else {
                    j++;
                }
                n = n.next;
            }
            p = p.next;

        }
    }
}
