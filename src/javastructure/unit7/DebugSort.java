package javastructure.unit7;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class DebugSort {
    public static int[] constUnSort = {52, 39, 67, 95, 79, 8, 25, 52};
    public static void main(String[] args) {
        int[] unSort1 = {52, 39, 67, 95, 79, 8, 25, 52};
        int[] unSort2 = {52, 39, 67, 95, 79, 8, 25, 52, 11, 47, 88, 105, 3, 114, 79};
        int[] unSort3 = {95, 79, 67, 52, 52, 39, 25, 8};
        int[] heap1 = {63, 25, 18, 33, 58, 95, 46, 13};
        DebugSort debug = new DebugSort();
//        debug.insertSortWithGuard(unSort1);
//        debug.shellSort(unSort1);
//        debug.shellSort(unSort2);
//        debug.bubbleSort(unSort3);
//        debug.quickSort(constUnSort, 0, unSort1.length - 1);
//        System.out.println("快排：");
//        System.out.println(Arrays.toString(constUnSort));
//        debug.selectSort(unSort1);
//        debug.siftHeap(heap1, 0, heap1.length - 1);
//        System.out.println(Arrays.toString(debug.createHeap(unSort1)));
//        debug.heapSort(unSort1);
        debug.mergeSort(unSort1);
    }

    public void insertSortWithGuard(int[] a) {
        int[] m = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            m[i + 1] = a[i];
        }
        int i, j;
        for (i = 1; i < m.length; i++) {
            m[0] = m[i];
            for (j = i - 1; m[0] < m[j]; j--) {
                m[j + 1] = m[j];
            }
            m[j + 1] = m[0];
        }
        System.out.println("直接排序前：");
        System.out.println(Arrays.toString(a));
        System.out.println("直接排序后：");
        System.out.println(Arrays.toString(m));
    }

    public void shellSort(int[] a) {
        System.out.println("希尔排序前:");
        System.out.println(Arrays.toString(a));
        //初始化d数组
        double n = (double) a.length;
        int k = (int) (Math.log(n / 2.0 + 1.0) / Math.log(2.0));
        int[] d = new int[k];
        for (int i = 0, j = k; i < k; i++, j--) {
            d[i] = (int) Math.pow(2, j) - 1;
        }
        System.out.println("数组d：" + Arrays.toString(d));
        int i, j;
        int temp;
        for (int m = 0; m < d.length; m++) {
            int dk = d[m];//步长
            for (i = dk; i < a.length; i++) {
                temp = a[i];
                for (j = i - dk; j >= 0 && temp < a[j]; j -= dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = temp;
            }
        }
        System.out.println("希尔排序后:");
        System.out.println(Arrays.toString(a));
    }

    public void bubbleSort(int[] a) {
        System.out.println("冒泡排序前:");
        System.out.println(Arrays.toString(a));
        int temp;
        int i, j;
        boolean flag = true;
        for (i = a.length; flag && i > 1; i--) {
            flag = false;
            for (j = 0;j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("冒泡排序后:");
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = Partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
//        else {
//            System.out.println(Arrays.toString(a));
//        }

    }

    private int Partition(int[] a, int i, int j) {
        int pivot = a[i];
        while (i < j) {
            while (i < j && a[j] > pivot) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < pivot) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = pivot;
        return i;
    }

    public void selectSort(int[] a) {
        int temp;
        int min;
        int i,j;
        for (i = 0; i < a.length; i++) {
            min = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
//        System.out.println("选择排序：" + Arrays.toString(a));
    }

    public void treeSort(int[] a) {

    }
    //交换堆顶元素和堆尾元素，并使之还是堆 low序列的下界，high序列的上界
    public void siftHeap(int[] a, int low, int high) {
        int i = low;
        int j = 2 * i + 1;
        int temp = a[i];
        while (j <= high) {
            if (j <= high - 1 && a[j] > a[j + 1]) {//当右结点比左结点小，交换的是右结点
                j++;
            }
            if (temp > a[j]) {
                a[i] = a[j];
                i = j;
                j = 2 * i + 1;
            } else {
                break;
            }
        }
        a[i] = temp;
//        System.out.println(Arrays.toString(a));
    }

    //生成堆
    public int[] createHeap(int[] a) {
        int n = a.length;
        int i;
        for (i = n / 2 - 1; i >= 0; i--) {
            siftHeap(a, i, n - 1);
//            temp = a[i];
//            j = i * 2 + 1;
//            while (j < n) {
//                if (j < n - 1 && a[j] > a[j + 1]) {
//                    j++;
//                }
//                if (temp > a[j]) {
//                    a[i] = a[j];
//                    i = j;
//                    j = i * 2 + 1;
//                } else {
//                    break;
//                }
//            }
//            a[i] = temp;
        }
        return a;
    }

    //堆排序：把最小堆中的元素按从大到小排列在数组中
    public void heapSort(int[] a) {
        int[] heap = createHeap(a);
        int n = heap.length;
        int temp;
        for (int i = n - 1; i > 0; i--) {
            //把最小堆首位元素交换
            temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            siftHeap(heap, 0, i - 1);
        }
        System.out.println(Arrays.toString(heap));
    }

    public void merge(int[] a, int[] order, int h, int m, int t) {
        int i = h, j = m + 1, k = h;
        while (i <= m && j <= t) {
            if (a[i] < a[j]) {
                order[k++] = a[i++];
            } else {
                order[k++] = a[j++];
            }
        }
        while (i <= m) {
            order[k++] = a[i++];
        }
        while (j <= t) {
            order[k++] = a[j++];
        }
    }

    public void mergePass(int[] a, int[] order, int s, int n) {
        int p = 0;
        while (p + 2 * s - 1 <= n - 1) {
            merge(a, order, p, p + s - 1, p + 2 * s - 1);
            p += 2 * s;
        }
        if (p + s - 1 < n - 1) {
            merge(a, order, p, p + s - 1, n - 1);
        } else {
            for (int i = p; i < n; i++) {
                order[i] = a[i];
            }
        }
    }

    public void mergeSort(int[] a) {
        System.out.println(Arrays.toString(a));
        System.out.println("归并排序：");
        int s = 1;//初始长度设为1
        int n = a.length;
        int[] temp = new int[n];
        while (s < n) {
            mergePass(a, temp, s, n);
            s *= 2;
            mergePass(temp, a, s, n);
            s *= 2;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(temp));
    }


}
