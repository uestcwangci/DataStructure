package javastructure.unit2;

import java.util.Scanner;

public class Work4 {
    public static void main(String[] args) throws Exception {
        work4_4();
    }

    private static void work4_4() throws Exception {
        DoubleLinkList list = new DoubleLinkList();
        for (int i = 0; i < 10; i++) {
            list.insert(i, i);
        }
        TwoWayNode s = list.head.last;
        for (int i = 0; i < 5; i++) {
            System.out.println(s.data);
            s = s.last;
        }
        System.out.println(list.isEmpty());
        list.display();
        Scanner sc = new Scanner(System.in);
        list.insert(4, -8);
        list.display();
        System.out.println(list.length());
        TwoWayNode p = (TwoWayNode) list.get(sc.nextInt());
        System.out.println(p.data);
        System.out.println(list.indexOf(4));
        list.remove(3);
        list.display();
        list.clear();
        System.out.println(list.isEmpty());
        list.display();
    }
}
