package javastructure.unit2;

public class DoubleLinkList implements Ilist {
    public TwoWayNode head;


    public DoubleLinkList() {
        this.head = new TwoWayNode();
        head.next = head;
        head.last = head;
    }

    @Override
    public void clear() {
        head.next = head;
        head.last = head;
    }

    @Override
    public boolean isEmpty() {
        return (head.next == head && head.last == head);
    }

    @Override
    public int length() {
        int j = 0;
        TwoWayNode p = head.next;
        while (p != head) {
            p = p.next;
            j++;
        }
        return j;
    }

    @Override
    public Object get(int i) throws Exception {
        TwoWayNode p = head.next;
        int j = 0;
        while (p != head && j < i) {
            p = p.next;
            j++;
        }
        if (j > i || p == head) {
            throw new Exception("获取第" + i + "个元素失败");
        }
        return p;
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        TwoWayNode p = head.next;
        int j = 0;
        if (isEmpty() && i == 0) {
            TwoWayNode s = new TwoWayNode(x);
            head.next = s;
            head.last = s;
            s.next = head;
            s.last = head;
            return;
        }
        while (p != head && j < i) {//找当前节点
            p = p.next;
            j++;
        }
        if (j != i && p == head) {
            throw new Exception("插入第" + i + "个元素失败");
        }
        TwoWayNode s = new TwoWayNode(x);
        s.next = p;
        s.last = p.last;
        p.last.next = s;
        p.last = s;
    }

    @Override
    public void remove(int i) throws Exception {
        int j = 0;
        TwoWayNode p = head.next;
        while (p != head && j < i) {// 找到当前节点
            p = p.next;
            j++;
        }
        if (j > i || p == head) {
            throw new Exception("删除第" + i + "个元素失败");
        }
        TwoWayNode l = p.last;
        TwoWayNode n = p.next;
        l.next = n;
        n.last = l;
    }

    @Override
    public int indexOf(Object x) {
        TwoWayNode p = head.next;
        int j = 0;
        while (p != head && !p.data.equals(x)) {
            p = p.next;
            j++;
        }
        if (p != head) {
            return j;
        }
        return -1;
    }

    @Override
    public void display() {
        TwoWayNode p = head.next;
        while (p != head) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();

    }


}
