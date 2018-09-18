package javastructure.unit2;

public class SequenceTable implements Ilist {
    private Object[] listElem;
    private int curLen;

    public SequenceTable(int maxSize) {
        this.curLen = 0;
        listElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        this.curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public Object get(int i) throws Exception{
        if (i < 0 || i > curLen - 1) {
            throw new Exception("第" + i + "个元素不存在");
        }
        return listElem[i];
    }

    @Override
    public void insert(int i, Object x)throws Exception {
        if (curLen == listElem.length) {
            throw new Exception("线性表已满");
        }
        if (i < 0 || i > curLen) {
            throw new Exception("超出插入范围");
        }
        for (int j = curLen; j > i; j--) {
            listElem[j] = listElem[j - 1];
        }
        listElem[i] = x;
        curLen++;

    }

    @Override
    public void remove(int i) throws Exception{
        if (i < 0 || i > curLen - 1) {
            throw new Exception("无法删除" + i + "位数据");
        }
        for (int j = i; j < curLen - 1; j++) {
            listElem[j] = listElem[j + 1];
        }
        curLen--;
    }

    @Override
    public int indexOf(Object x) {
        int j = 0;
        while (j < curLen && !listElem[j].equals(x)) {
            j++;
        }
        if (j < curLen) {
            return j;
        } else {
            return -1;
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < curLen; i++) {
            System.out.print(listElem[i] + " | ");
        }
        System.out.println();
    }
}
