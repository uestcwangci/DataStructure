package javastructure.unit4.work;

import javastructure.unit4.CrossList;

public class Work4_3 {


    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 0, 8, 0},
        };
        int[] inElem = {1, 2, 3};//在1行，2列插入元素3
        int rows = mat.length;
        int cols = mat[0].length;
        CrossList crossList = new CrossList(rows, cols);
//        crossList.display();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    crossList.insert(i + 1, j + 1, mat[i][j]);
                }
            }
        }
        System.out.println("原稀疏矩阵：");
        crossList.display();
        System.out.println("在" + inElem[0] + "行" + inElem[1] + "列插入" + inElem[2]);
        crossList.insert(inElem[0], inElem[1], inElem[2]);
        crossList.display();
        int[] inElem1 = {3, 3, -5};
        System.out.println("在" + inElem1[0] + "行" + inElem1[1] + "列插入" + inElem1[2]);
        crossList.insert(inElem1[0], inElem1[1], inElem1[2]);
        crossList.display();
    }
}
