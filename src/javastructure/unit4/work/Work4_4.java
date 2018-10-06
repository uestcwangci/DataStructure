package javastructure.unit4.work;

import javastructure.unit4.CrossList;
import javastructure.unit4.OLNode;
import javastructure.unit4.SpareMatrix;

public class Work4_4 {
    public static void main(String[] args) {
        Work4_4 work = new Work4_4();
        int[][] mat = {
                {0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 0, 8, 0},
        };
        int rows = mat.length;
        int cols = mat[0].length;
        CrossList crossList = new CrossList(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    crossList.insert(i + 1, j + 1, mat[i][j]);
                }
            }
        }
        System.out.println("原稀疏矩阵：");
        crossList.display();
        System.out.println("用三元组输出十字链表：（行序优先）");
        work.cross2triple(crossList);

    }

    private void cross2triple(CrossList crossList) {
        SpareMatrix spareMatrix = new SpareMatrix(crossList.tu);
        spareMatrix.rows = crossList.mu;
        spareMatrix.columns = crossList.nu;
        spareMatrix.nums = crossList.tu;
        int k = 0;
        for (int i = 0; i < crossList.mu; i++) {
            OLNode rTemp = crossList.rhead[i].right;
            while (rTemp != null) {
                spareMatrix.data[k].row = rTemp.row;
                spareMatrix.data[k].column = rTemp.col;
                spareMatrix.data[k++].value = rTemp.e;
                rTemp = rTemp.right;
            }
        }
        spareMatrix.printMatrix();
    }
}
