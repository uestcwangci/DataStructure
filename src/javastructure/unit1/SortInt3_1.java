package javastructure.unit1;

import java.util.Arrays;

public class SortInt3_1 {
    private static final int K = 20;
    public static void main(String[] args) {
        int[] in = new int[K];
        for (int i = 0; i < K; i++) {
            in[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(in));
        System.out.println(Arrays.toString(mySort(in)));
    }

    private static int[] mySort(int[] in) {
        int temp = 0;
        for (int i = in.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (in[j] > in[j + 1]) {
                    temp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = temp;
                }
            }
        }
        return in;
    }
}
