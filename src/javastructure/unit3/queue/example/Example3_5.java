package javastructure.unit3.queue.example;

import javastructure.unit2.SequenceTable;
import javastructure.unit3.queue.LinkQueue;

public class Example3_5 {
    private static int funCount = 0;
    public static void main(String[] args) throws Exception {
        Example3_5 ex = new Example3_5();
        SequenceTable L = ex.makePrimeRing(6);
//        for (int i = 0; i < L.length(); i++) {
//            System.out.print(L.get(i) + " ");
//        }
        L.display();
        System.out.println(funCount);
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private SequenceTable makePrimeRing(int n) throws Exception {
        if (n % 2 != 0) {
            throw new Exception("素数环不存在");
        }
        SequenceTable L = new SequenceTable(n);
        L.insert(0, 1);
        LinkQueue Q = new LinkQueue();
        for (int i = 2; i <= n; i++) {
            Q.offer(i);
        }
        return insertRing(L, Q, 2, n);
    }

    private SequenceTable insertRing(SequenceTable L, LinkQueue Q, int m, int n) throws Exception {
        funCount++;
        int count = 0;
        while (!Q.isEmpty() && count <= n - m) {
            int p = (int) Q.poll();
            int q = (int) L.get(L.length() - 1);
            if (m == n) {
                if (isPrime(p + q) && isPrime(p + 1)) {
                    L.insert(L.length(), p);
                    return L;
                } else {
                    Q.offer(p);
                }
            } else if (isPrime(p + q)) {
                L.insert(L.length(), p);
                if (insertRing(L, Q, m + 1, n) != null) {
                    return L;
                }
                L.remove(L.length() - 1);
                Q.offer(p);
            } else {
                Q.offer(p);
            }
            ++count;
        }
        return null;
    }
}
