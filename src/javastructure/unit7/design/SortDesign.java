package javastructure.unit7.design;

import javafx.util.Pair;
import javastructure.unit2.LinkList;
import javastructure.unit2.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class SortDesign {
    private static int[] constArray = {50, 40, 95, 20, 15, 70, 60, 45, 85, 3};
    public static void main(String[] args) throws Exception {
        SortDesign design = new SortDesign();
        LinkList L = new LinkList();
        int[] a = {50, 40, 95, 20, 15, 70, 60, 45, 85, 3};
        int[] tree = {98, 76, 52, 37, 45, 67, 38, 18};
        int[] tree1 = {98, 76, 52, 37, 45, 22, 38, 18};
        for (int i = 0; i < 10; i++) {
            L.insert(i, a[i]);
        }
        System.out.println("排序前：");
        L.display();
        System.out.println();
        design.design1(L);
        design.design2(L);
        design.doubleBubble(a);
        design.fastSort(constArray);
        design.isHeap(tree);
        design.isHeap(tree1);
    }

    //插入排序对单链表排序
    public void design1(LinkList L) {
        System.out.println("插入法单链表排序：");
        Node p;
        Node q;
        Node compareNode;
        Node last = L.head.next;//记录新链表的最后一个节点
        while (last.next != null) {
            compareNode = last.next;//从第二个节点开始做插入
            q = L.head;//记录上一个节点
            p = q.next;//新链表第一个节点
            while (p != compareNode && ((int) compareNode.data > (int) p.data)) {
                q = p;
                p = p.next;
            }
            if (p == compareNode) {//比较到最后一个节点
                last = compareNode;
            } else {
                q.next = compareNode;
                last.next = compareNode.next;
                compareNode.next = p;
            }
        }
        L.display();
        System.out.println();
    }

    //选择排序对链表进行排序
    public void design2(LinkList L) {
        System.out.println("选择排序：");
        Node p, q;
        Node minNode = L.head;
        Node preMin;
        Node last = L.head;
        while (last.next != null) {
            minNode = last.next;
            q = last;
            preMin = last;
            p = q.next;
            while (p != null) {
                if ((int) p.data < (int) minNode.data) {
                    minNode = p;
                    preMin = q;
                }
                q = p;
                p = p.next;
            }
            preMin.next = minNode.next;
            minNode.next = last.next;
            last.next = minNode;
            last = minNode;
        }
        L.display();
    }

    //双向冒泡
    public void doubleBubble(int[] a) {
        System.out.println("\n双向冒泡排序：");
        int temp;
        int i;
        int left = 0;
        int right = a.length - 1;
        boolean flag1, flag2;
        flag1 = flag2 = false;
        while (true) {
            for (i = left; i < a.length - 1; i++) {//首次冒泡把最大的数字放到end
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flag1 = false;
                }
            }
            right--;
            if (left == right) {
                break;
            }
            for (i = right; i >= 1; i--) {
                if (a[i - 1] > a[i]) {
                    temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    flag2 = false;
                }
            }
            left++;
            if (left == right || (flag1 && flag2)) {
                break;
            }
            flag1 = flag2 = true;
        }
        System.out.println(Arrays.toString(a));
    }

    public void fastSort(int[] a) {
        System.out.println("非递归快排：");
        Stack<leftRight> S = new Stack<>();
        S.push(new leftRight(0, a.length - 1));
        int left, right;
        int anchor;
        while (!S.isEmpty()) {
            leftRight leftRight = S.pop();
            left = leftRight.left;
            right = leftRight.right;
            if (left >= right) {
                continue;
            }
            anchor = fastInner(a, left, right);
            //先入右边，再入左边
            if (anchor < right) {
                S.push(new leftRight(anchor + 1, right));
            }
            if (left < anchor) {
                S.push(new leftRight(left, anchor - 1));
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private int fastInner(int[] a, int start, int end) {
        int pivot = a[start];
        while (start < end) {
            while (start < end && pivot < a[end]) {
                end--;
            }
            if (start < end) {
                a[start++] = a[end];
            }
            while (start < end && pivot > a[start]) {
                start++;
            }
            if (start < end) {
                a[end--] = a[start];
            }
        }
        a[start] = pivot;
        return start;
    }

    public void isHeap(int[] tree) {
        int j = tree.length - 1;
        int bigger;
        if (j % 2 == 0) {
            bigger = tree[j - 1] > tree[j] ? tree[j - 1] : tree[j];
            if (tree[j / 2 - 1] < bigger) {
                System.out.println("不是最大堆");
                return;
            }
            j = j - 2;
        } else {
            bigger = tree[j];
            if (tree[j / 2 - 1] < bigger) {
                System.out.println("不是最大堆");
                return;
            }
            j--;
        }
        while (j >= 2) {
            bigger = tree[j - 1] > tree[j] ? tree[j - 1] : tree[j];
            if (tree[j / 2 - 1] < bigger) {
                System.out.println("不是最大堆");
                return;
            }
            j = j - 2;
        }
        System.out.println("是最大堆");
    }


}
