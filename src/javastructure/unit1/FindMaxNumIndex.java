package javastructure.unit1;

import java.util.Arrays;

public class FindMaxNumIndex {
    public static void main(String[] args) {
        double[] in = new double[100];
        for (int i = 0; i < in.length; i++) {
            in[i] = (Math.random() - 0.5) * 100;// 生成[-50, 50]随机实数
        }
        double[] a = new double[2];
        a = findMax(in);
        System.out.println(Arrays.toString(in));
        System.out.println("下标：" + (int) a[0]);
        System.out.println("最大值" + a[1]);

    }

    private static double[] findMax(double[] in) {
        double maxNum = Double.MIN_VALUE;
        int maxIndex = 0;
        double[] out = new double[2];
        for (int i = 0; i < in.length; i++) {
            if (in[i] > maxNum) {
                maxNum = in[i];
                maxIndex = i;
            }
        }
        out[0] = (double) maxIndex;
        out[1] = maxNum;
        return out;
    }
}
