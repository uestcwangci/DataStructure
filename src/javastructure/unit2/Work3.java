package javastructure.unit2;

import javax.naming.NoPermissionException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Work3 {
    private static final int ODD = 1;
    private static final int EVEN = 0;
    public static void main(String[] args) throws Exception{
        SequenceTable sequenceTable = new SequenceTable(50);
        for (int i = 0; i < 10; i++) {
            sequenceTable.insert(i, i);
        }

        int K = 10;
        int[] sequenceList = new int[K];
        LinkList linkList = new LinkList();

        for (int i = 0; i < K; i++) {
            sequenceList[i] = i;
            linkList.insert(i, 2 * (i + 1));
        }

        Scanner sc = new Scanner(System.in);
        int inNum = sc.nextInt();
//        exam3_1(sequenceTable);
//        exam3_2(sequenceList);
//        exam3_3(linkList, 15);
//        exam3_4(linkList);
//        System.out.println("\n" + exam3_5(linkList, 21));
//        System.out.println("\n" + exam3_6(linkList, inNum));

    }

    private static void exam3_1(SequenceTable table) throws Exception{
        System.out.println("倒序前的列表：");
        table.display();
        int temp = -1;
        for (int i = 0, j = table.length() - 1; i < j; i++, j--) {
            temp = (int) table.get(i);
            table.insert(i, table.get(j));
            table.remove(i + 1);
            table.insert(j, temp);
            table.remove(j + 1);
        }
        System.out.println("倒序后的列表：");
        table.display();

    }

    private static void exam3_2(int[] in) {
        System.out.println("循环前的列表：");
        for (int m = 0; m < in.length; m++) {
            System.out.print(in[m] + " | ");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\n输入移动的位数:");
        int k = sc.nextInt();
        int n = in.length, p = 0, i, j, l;//curLen为顺序表的当前长度
        k = k % n;
        int temp;
        for (i = 1; i <= k; i++) {
            if (n % i == 0 && k % i == 0) { //求n和k的最大公约数p
                p = i;
            }
        }

        for (i = 0; i < p; i++) {
            j = i;
            l = (i + n - k) % n; //找到即将右移到第i位的数
            temp = in[i];//listElem为顺序表的存储空间
            while (l != i) {
                in[j] = in[l];
                j = l;
                l = (j + n - k) % n;
            }//循环右移一步
            in[j] = temp;
        }
        System.out.println("右移" + k + "位后的列表：");
        for (int m = 0; m < in.length; m++) {
            System.out.print(in[m] + " | ");
        }
    }

    private static void exam3_3(LinkList list, Object x) {
        Node h = list.head;
        Node s = new Node(x);
        while (h.next != null) {
            if ((int) h.next.data > (int) x) {
                break;
            }
            h = h.next;
        }
        s.next = h.next;
        h.next = s;
        list.display();
    }

    private static void exam3_4(LinkList list) {
        System.out.println("倒序前：");
        list.display();
        Node h = list.head;
        Node p = h.next;
        h.next = null;
        Node q;
        while (p != null) {
            q = p.next;
            p.next = h.next;
            h.next = p;
            p = q;
        }
        System.out.println("\n倒序后：");
        list.display();
    }

    private static int exam3_5(LinkList list, Object x) {
        Node h = list.head;
        h = h.next; // 删除头结点，使之成为无头结点链
        System.out.println("原链表：");
        list.display();
        int index = 1;
        if (h.data.equals(x)) {
            list.head = h;
            System.out.println("\n删除后链表:");
            list.display();
            return 0;
        }
        while (h.next != null) {
            if (h.next.data.equals(x)) {
                h.next = h.next.next;
                System.out.println("\n删除后链表:");
                list.display();
                return index;
            } else {
                index++;
            }
            h = h.next;
        }
        System.out.println("\n删除后链表:");
        list.display();
        return -1;
    }

    private static int exam3_6(LinkList list, Object x) {
        System.out.println("原链表：");
        list.display();
        Node h = list.head;
        int index = 0;
        while (h.next != null && !h.next.data.equals(x)) {
            h = h.next;
            index++;
        }
        if (h.next == null) {
            System.out.println("\n删除后链表：");
            list.display();
            return -1;
        } else {
            h.next = h.next.next;
        }
        System.out.println("\n删除后链表：");
        list.display();
        return index;
    }

    private static void exam3_7() throws Exception {
        LinkList oddList = CycleList(ODD);
        LinkList evenList = CycleList(EVEN);
        LinkList combineList = new LinkList();

    }

    // 生成循环链表
    private static LinkList CycleList(int c) throws Exception {
        DecimalFormat df = new DecimalFormat("#.00");
        LinkList list = new LinkList();
        for (int i = 0; i < 5; i++) {
            PolyData data = new PolyData(Double.parseDouble(df.format((Math.random() - 0.5) * 10)), i + c);
            list.insert(i, data);
        }
        Node h = list.head;
        Node p = h.next;
        if (p.next != null) {
            p = p.next;
        }
        p.next = h;
        return list;
    }

}
