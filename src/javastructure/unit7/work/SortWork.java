package javastructure.unit7.work;

import java.text.NumberFormat;
import java.util.Arrays;

public class SortWork {
    private static Student[] students = new Student[10];
    private static double[] scores = new double[students.length];
    private static int[] indexs = new int[students.length];
    public static void main(String[] args) {
        SortWork work = new SortWork();
        int[] guard = {-1, 50, 40, 95, 20, 15, 70, 60, 45, 85, 3};
        int[] a = {50, 40, 95, 20, 15, 70, 60, 45, 85, 3};
        work.insertSortWithGuard(guard);
        createStudentList();
        System.out.println("排序前：");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        for (int i = 0; i < students.length; i++) {
            scores[i] = students[i].score;
            indexs[i] = i;
        }
        work.heapSort(scores);
        System.out.println("排序后：");
        sortByScore();
        work.myMergeSort(a);
    }

    public void insertSortWithGuard(int[] a) {
        System.out.println("哨岗插排：");
        int j;
        for (int i = 1; i < a.length; i++) {
            a[0] = a[i];
            for (j = i - 1; a[0] < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = a[0];
        }
        System.out.println(Arrays.toString(a));
    }

    public static void createStudentList() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(1);
        students[0] = new Student(10001, "Bob", Double.valueOf(nf.format(Math.random() * 100)));
        students[1] = new Student(10002, "Alice", Double.valueOf(nf.format(Math.random() * 100)));
        students[2] = new Student(10003, "Crash", Double.valueOf(nf.format(Math.random() * 100)));
        students[3] = new Student(10004, "Devi", Double.valueOf(nf.format(Math.random() * 100)));
        students[4] = new Student(10005, "Ella", Double.valueOf(nf.format(Math.random() * 100)));
        students[5] = new Student(10006, "Flash", Double.valueOf(nf.format(Math.random() * 100)));
        students[6] = new Student(10007, "Gucci", Double.valueOf(nf.format(Math.random() * 100)));
        students[7] = new Student(10008, "Happy", Double.valueOf(nf.format(Math.random() * 100)));
        students[8] = new Student(10009, "Iove", Double.valueOf(nf.format(Math.random() * 100)));
        students[9] = new Student(10010, "Jacky", Double.valueOf(nf.format(Math.random() * 100)));
    }

    public static void sortByScore() {
        for (int i = students.length - 1; i >= 0; i--) {
            System.out.println(students[indexs[i]]);
        }
    }

    public void siftHeap(double[] tree, int low, int high) {
        int i = low;
        int j = i * 2 + 1;//左结点
        double temp = tree[i];
        int t = indexs[i];
        while (j <= high) {
            if (j < high && tree[j] > tree[j + 1]) {//第一个判定是否有右结点
                j++;
            }
            if (temp > tree[j]) {
                tree[i] = tree[j];
                indexs[i] = indexs[j];
                i = j;
                j = j * 2 + 1;
            } else {
                break;
            }
        }
        tree[i] = temp;
        indexs[i] = t;
    }

    public void createHeap(double[] tree) {
        int j = tree.length - 1;
        for (int k = (j + 1) / 2 - 1; k >= 0; k--) {
            siftHeap(tree, k, j);
        }
    }

    public void heapSort(double[] heap) {
        createHeap(heap);
        int j = heap.length - 1;
        double temp;
        int t;
        for (int k = j; k > 0; k--) {
            temp = heap[0];
            heap[0] = heap[k];
            heap[k] = temp;
            t = indexs[0];
            indexs[0] = indexs[k];
            indexs[k] = t;
            siftHeap(heap, 0, k - 1);
        }
//        System.out.println(Arrays.toString(heap));
    }

    public void myMerge(int[] a, int[] order, int p, int m, int t) {
        int i = p;
        int j = m;
        int k = p;
        while (i < m && j <= t) {
            if (a[i] < a[j]) {
                order[k++] = a[i++];
            } else {
                order[k++] = a[j++];
            }
        }
        while (i < m) {
            order[k++] = a[i++];
        }
        while (j <= t) {
            order[k++] = a[j++];
        }
//        System.out.println(Arrays.toString(order));
    }

    public void myMergePass(int[] a, int[] order, int n, int s) {//s为归并序列的长度，n为序列最后一个位置
        int p = 0;
        while (p + 2 * s - 1 <= n) {
            myMerge(a, order, p, p + s, p + 2 * s - 1);
            p = p + 2 * s;
        }
        if (p + s <= n) {
            myMerge(a, order, p, p + s, n);
        } else {
            while (p <= n) {
                order[p] = a[p];
                p++;
            }
        }
    }

    public void myMergeSort(int[] a) {
        int s = 1;
        int n = a.length;
        int[] order = new int[n];
        while (s < n) {
            myMergePass(a, order, n - 1, s);
            s *= 2;
            myMergePass(order, a, n - 1, s);
            s *= 2;
        }
        System.out.println(Arrays.toString(order));
        System.out.println(Arrays.toString(a));
    }
}
