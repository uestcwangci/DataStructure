package zheda.unit1;

import java.util.Map;

public class MyDemo1 {
    private static final int MAXP = 10;
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        double a[] = new double[MAXP];
        for (int i = 0; i < MAXP; i++) {
            a[i] = i;
        }
        double result;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            fun4(1.1);
        }
        endTime = System.currentTimeMillis();
        result = fun4(1.1);
        System.out.println(result);
        System.out.println("花费时间:" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            fun3(1.1);
        }
        endTime = System.currentTimeMillis();
        result = fun3(1.1);

        System.out.println(result);
        System.out.println("花费时间:" + (endTime - startTime) + "ms");
    }

    private static double fun1(int num, double a[], double x) {
        double p;
        p = a[0];
        for (int i = 1; i < num; i++) {
            p += a[i] * Math.pow(x, i);
        }
        return p;
    }

    private static double fun2(int num, double a[], double x) {
        double p;
        p = a[num - 1];
        for (int i = num - 1; i > 0; i--) {
            p = a[i - 1] + x * p;
        }
        return p;
    }

    private static double fun3(double x) {
        double p = 1;
        for (int i = 1; i <= 100; i++) {
            p += Math.pow(x, i) / i;
        }
        return p;
    }

    private static double fun4(double x) {
        double p = 1/100.0;
        for (int i = 100; i > 1; i--) {
            p = 1 / ((double)(i-1)) + x * p;
        }
        p = 1 + p * x;
        return p;
    }
}
