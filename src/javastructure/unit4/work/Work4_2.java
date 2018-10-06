package javastructure.unit4.work;

import javastructure.unit4.SpareMatrix;

public class Work4_2 {
    public static void main(String[] args) {
        int[][] mat1 = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0}
        };
        int[][] mat2 = new int[][]{
                {0, 0, 0, 0},
                {0, 5, 0, 0},
                {1, 1, 0, 0},
                {0, 7, 0, 0}
        };
        SpareMatrix sm1 = new SpareMatrix(mat1);
        SpareMatrix sm2 = new SpareMatrix(mat2);
        Work4_2 work = new Work4_2();
        work.triplePlus(sm1, sm2);

    }

    private void triplePlus(SpareMatrix m1, SpareMatrix m2) {
        int rows = m1.rows;
        int columns = m1.columns;
        int k1 = 0;
        int k2 = 0;
        int[][] mat = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (k1 < m1.nums && m1.data[k1].row == i && m1.data[k1].column == j) {
                    mat[i][j] += m1.data[k1++].value;
                }
                if (k2 < m2.nums && m2.data[k2].row == i && m2.data[k2].column == j) {
                    mat[i][j] += m2.data[k2++].value;
                }
            }
        }
        SpareMatrix result = new SpareMatrix(mat);
        result.printMatrix();
    }

}
