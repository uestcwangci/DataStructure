package javastructure.unit4.fast_transposition;

import javastructure.unit4.SpareMatrix;
import javastructure.unit4.TripleNode;

public class FastTransposition {
    public static void main(String[] args) {
        FastTransposition ft = new FastTransposition();
        int mat[][] = new int[][]{
                {0, 0, 8, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 16, 0},
                {0, 0, 18, 0, 0, 0},
                {0, 0, 0, 9, 0, 0}};
        SpareMatrix matrix = ft.createSpMatrix(mat);
        System.out.println("转置前：");
        matrix.printMartrix();
        SpareMatrix afterTrans = ft.fastTransposition(matrix);
        System.out.println("转置后：");
        afterTrans.printMartrix();


    }

    private SpareMatrix createSpMatrix(int mat[][]) {
        int k = 0;
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    count++;
                }
            }
        }
        SpareMatrix sm = new SpareMatrix(count);
        sm.nums = count;
        sm.rows = mat.length;
        sm.columns = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    sm.data[k] = new TripleNode(i, j, mat[i][j]);
                    k++;
                }
            }
        }
        return sm;
    }

    private SpareMatrix fastTransposition(SpareMatrix before) {
        SpareMatrix after = new SpareMatrix(before.nums);
        after.rows = before.columns;
        after.columns = before.rows;
        after.nums = before.nums;
        int[] num;//num[col]表示原始三元表第col列非零元素个数
        int[] cpot;//cpot[num]表示第col列第一个非零元素在转置后的位置
        if (before.nums > 0) {
            num = new int[before.columns];
            cpot = new int[before.columns];
            for (int i = 0; i < before.nums; i++) {
                num[before.data[i].column]++;
            }
            cpot[0] = 0;//第0列
            for (int i = 1; i < before.nums; i++) {
                cpot[i] = cpot[i - 1] + num[i - 1];
            }
            //转置
            int c;
            int q;
            for (int i = 0; i < before.nums; i++) {
                c = before.data[i].column;
                q = cpot[c];
                after.data[q].column = before.data[i].row;
                after.data[q].row = before.data[i].column;
                after.data[q].value = before.data[i].value;
                cpot[c]++;//起始位置存放后，在此位置+1
            }
        }
        return after;
    }


}

