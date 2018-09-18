package javastructure.unit2;

import java.util.Scanner;

public class LinkList implements Ilist {
    public Node head;

    public LinkList() {
        head = new Node();
    }

    public LinkList(int n, boolean order) throws Exception{
        this();
        if (order) {
            createTail(n);
        } else {
            createHead(n);
        }
    }

    public void createTail(int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            try {
                insert(i, sc.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void createHead(int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            try {
                insert(0, sc.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void clear() {
        head.next = null;
        head.data = null;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int length() {
        Node p = head.next;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    @Override
    public Object get(int i) throws Exception {
        Node p = head.next;
        int j = 0;
        while (p.next != null && j < i) {
            p = p.next;
            j++;
        }
        if (j > i || p == null) {
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.data;
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1) {// 找到前向结点
            p = p.next;
            j++;
        }
        if (j > i - 1 || p == null) {
            throw new Exception("插入第" + i + "个位置失败");
        }
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;

    }

    @Override
    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        while (p.next != null && j < i - 1) {// 找到前向结点
            p = p.next;
            j++;
        }
        if (j > i - 1 || p.next == null) {
            throw new Exception("第" + i + "个元素删除失败");
        }
        p.next = p.next.next;
    }

    @Override
    public int indexOf(Object x) {
        Node p = head.next;
        int j = 0;
        while (p != null && !p.data.equals(x)) {
            p = p.next;
            j++;
        }
        if (p != null) {
            return j;
        } else {
            return -1;
        }
    }

    @Override
    public void display() {
        Node p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }

    }
}
