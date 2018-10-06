package javastructure.unit4;

import javastructure.unit3.queue.LinkQueue;
import javastructure.unit4.examples.KMP.bookKMP;

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
        curlen = newCapacity;
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
        int totalLen = this.length() + str.length();
        int len1 = this.length();
        allocate(totalLen);
        for (int i = len1; i < totalLen; i++) {
            try {
                strvalue[i] = str.charAt(i - len1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
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


    public int count() {
        int j = 0;
        for (int i = 0; i < length(); i++) {
            if (' ' == (strvalue[i]) && i != length() - 1) {
                j++;
            }
        }
        return j;
    }

    public SeqString replace(int begin, SeqString s1, SeqString s2) throws Exception {
        SeqString source = this;
        SeqString ss = new SeqString("");
        int index = source.indexOf(s1, begin);
        while (index != -1) {
            ss.concat(source.substring(0, index));
            ss.concat(s2);
            source = (SeqString) source.substring(index + s1.length(), source.length());
            index = source.indexOf(s1, 0);
        }
        ss.concat(source);
        return ss;

    }

    public void reverse() {
        int left = 0;
        int right = this.length() - 1;
        for (; left < right; left++, right--) {
            char temp = strvalue[left];
            strvalue[left] = strvalue[right];
            strvalue[right] = temp;
        }
    }

    public SeqString deleteallchar(char c) throws Exception {
        SeqString ss = new SeqString("");//空字串
        SeqString source = this;
        SeqString str = new SeqString(String.valueOf(c));
        int index = -1;
        while ((index = source.indexOf(str, 0)) != -1) {
            ss.concat(source.substring(0, index));
            source = (SeqString) source.substring(index + 1, source.length());
        }
        ss.concat(source);
        return ss;
    }

    public int stringcount(IString str) throws Exception {
        int[] index = indexOfKMP(str, 0);
        return index.length;
    }


    @Override
    public int indexOf(IString str, int begin) throws Exception {
        int[] next = bookKMP.findNextVal(str);
        int i = begin;
        int j = 0;
        while (i < this.length() && j<str.length()) {
            if (j == -1 || this.charAt(i) == str.charAt(j)) {//j=-1表示S[i]!=T[0] 主串下移一位，从串从0开始
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < str.length()) {
            return -1;
        } else {
            return i - j;
        }
    }

    public int[] indexOfKMP(IString str, int begin) throws Exception{
        int[] indexList;
        LinkQueue Q = new LinkQueue();
        int[] next = bookKMP.findNextVal(str);
        int i = begin;
        int j = 0;
        int count = 0;
        while (i < this.length()) {
            if (j == -1 || this.charAt(i) == str.charAt(j)) {//j=-1表示S[i]!=T[0] 主串下移一位，从串从0开始
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == str.length()) {
                Q.offer(i - j);
                count++;
                i += j;
                j = 0;
            }
        }
        if (Q.isEmpty()) {// 未找到
            return null;
        } else {
            indexList = new int[count];
            int ii = 0;
            while (!Q.isEmpty()) {
                indexList[ii++] = (int) Q.poll();
            }
            return indexList;
        }
    }

    public void display() {
        for (int i = 0; i < strvalue.length; i++) {
            System.out.print(strvalue[i]);
        }
        System.out.println();
    }
}
