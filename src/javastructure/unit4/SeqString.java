package javastructure.unit4;

public class SeqString implements IString {
    private char[] strvalue;
    private int curlen;

    public SeqString() {
        this.strvalue = new char[0];
        this.curlen = 0;
    }

    public SeqString(String str) {
        this.strvalue = str.toCharArray();
        this.curlen = str.length();
    }

    public SeqString(char[] value) {
        this.strvalue = value;
        this.curlen = value.length;
    }

    @Override
    public void clear() {
        this.curlen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curlen == 0;
    }

    @Override
    public int length() {
        return curlen;
    }

    @Override
    public char charAt(int index) throws Exception {
        if (index < 0 || index >= curlen) {
            throw new Exception("超出字符串范围");
        }
        return strvalue[index];
    }
    //改变字符串存储空间容量，参数指定容量
    public void allocate(int newCapacity) {
        char[] temp = strvalue;
        strvalue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }
    //返回从begin到end - 1的子串
    @Override
    public IString substring(int begin, int end) throws Exception {
        if (begin < 0 || begin > end || begin >= curlen || end > curlen) {
            throw new Exception("截取位置错误");
        }
        if (begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end - begin];
            for (int i = begin, j = 0; i < end; i++, j++) {
                buffer[j] = strvalue[i];
            }
            return new SeqString(buffer);
        }
    }
    //在第offset前插入串str
    @Override
    public IString insert(int offset, IString str) throws Exception {
        if (offset < 0 || offset > curlen) {
            throw new Exception("插入位置错误");
        }
        int strLen = str.length();
        int newLen = curlen + strLen;
        allocate(newLen);//扩容
        for (int i = newLen - 1; i > offset; i--) {//从offset开始元素向后挪
            strvalue[i] = strvalue[i - strLen];
        }
        for (int i = 0; i < strLen; i++) {//复制字符串
            strvalue[offset + i] = str.charAt(i);
        }
        this.curlen = newLen;
        return this;
    }
    //删除begin到end - 1的子串
    @Override
    public IString delete(int begin, int end) throws Exception {
        if (begin < 0 || end > curlen || begin > end) {
            throw new Exception("删除位置错误");
        }
        for (int i = 0; i < curlen - end; i++) {//移动字符串
            strvalue[begin] = strvalue[i + end];
        }
        allocate(curlen - (end - begin));//缩容
        curlen = curlen - (end - begin);
        return this;
    }
    //添加str到尾串
    @Override
    public IString concat(IString str) {
        return null;
    }

    @Override
    public int compareTo(IString str) {
        int len1 = curlen;
        int len2 = str.length();
        int n = Math.min(len1, len2);
        char[] s1 = strvalue;
        char[] s2 = ((SeqString) str).strvalue;
        int k = 0;
        while (k < n) {
            char c1 = s1[k];
            char c2 = s2[k];
            if (c1 != c2) {//返回第一个不相等字符的差值
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;//当前n位都相同时，返回字符串长度差
    }

    @Override
    public int indexOf(IString str, int begin) {
        return 0;
    }

    public void display() {
        for (int i = 0; i < strvalue.length; i++) {
            System.out.print(strvalue[i]);
        }
        System.out.println();
    }
}
