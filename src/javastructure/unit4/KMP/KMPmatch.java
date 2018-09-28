package javastructure.unit4.KMP;

public class KMPmatch {
    public static void main(String[] args) {
        KMPmatch kmp = new KMPmatch();
        String str = "aaaaaaaaab";
        String psr = "aaab";
        System.out.println("Brute_Force: " + kmp.bruteForce(str, psr, 0));
        System.out.println("KMP: " + kmp.KMP(str, psr));
    }

    private int bruteForce(String str, String ptr, int start) {
        int count = 0;
        int slen = str.length();
        int plen = ptr.length();
        int i = start;
        int j = 0;
        while ((i < slen) && (j < plen)) {
            if ((str.charAt(i) == ptr.charAt(j))) {
                i++;
                j++;
                count++;
            } else {
                i = i - j + 1;
                j = 0;
                count++;
            }
        }
        if (j >= plen) {
            System.out.println("暴力匹配" + count + "次");
            return i - plen;
        } else {
            System.out.println("暴力匹配" + count + "次");
            return -1;
        }
    }



    /***
     * next[i] = k 表示前i+1个字符中，相同的最长前缀和最长后缀的长度为k+1
     * @param str 主串
     * @return 返回next数组
     */
    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        char[] strArray = str.toCharArray();
        int k = -1;
        for (int i = 1; i < str.length(); i++) {
            while (k > -1 && strArray[k + 1] != strArray[i]) {
                k = next[k];
            }
            if (strArray[k + 1] == strArray[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    private int KMP(String sStr, String pStr) {
        int count = 0;
        int[] next = getNext(pStr);
        char[] strArray = sStr.toCharArray();
        char[] ptrArray = pStr.toCharArray();
        int k = -1;
        for (int i = 0; i < sStr.length(); i++) {
            while (k > -1 && ptrArray[k + 1] != strArray[i]) {
                k = next[k];
                count++;
            }
            if (ptrArray[k + 1] == strArray[i]) {
                k++;
                count++;
            }
            if (k == pStr.length() - 1) {//
                System.out.println("KMP匹配" + count + "次");
                return i - pStr.length() + 1;
            }
        }
        System.out.println("KMP匹配" + count + "次");
        return -1;
    }
}
