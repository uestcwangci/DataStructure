package zheda.unit1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Integer[] in = new Integer[K + 1];
        in[0] = K;
        for (int i = 1; i < K + 1; i++) {
            in[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(BinarySearch(in, target));
    }

    private static <E extends Comparable>Integer BinarySearch(E[] array, E target) {
        if ((int) array[0] <= 0) { // 当输入长度为0或为负，返回0
            return 0;
        }
        int left = 1;
        int right = array.length - 1;
        int center;
        while (left < right) {
            center = (left + right) / 2;
            if (target.compareTo(array[center]) == -1) {// 目标小于中间值
                right = center;
            } else if (target.compareTo(array[center]) == 1) {
                left = center + 1;
            } else {
                return center;
            }
        }
        return 0;
    }
}
