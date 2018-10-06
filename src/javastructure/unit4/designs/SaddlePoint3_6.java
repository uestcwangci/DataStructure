package javastructure.unit4.designs;

import javastructure.unit4.TripleNode;

public class SaddlePoint3_6 {
    //找到第i行最大，第j列最小的的数a(ij)
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,7,4,1},
                {4,8,3,6},
                {1,6,1,2},
                {0,7,8,9}};
        SaddlePoint3_6 ex3_6 = new SaddlePoint3_6();
        ex3_6.findSaddle(m);
    }

    private void findSaddle(int[][] matrix) {
        Result result = new Result(matrix.length);
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int q = 0;
            int flag = 1;
            int maxNum = Integer.MIN_VALUE;
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {//找到一行中最大的
                if (matrix[i][j] > maxNum) {
                    q = j;
                    maxNum = matrix[i][j];
                }
            }
            for (int j = 0; j < n; j++) {//找到一行中最大元素是否是这一列最小的
                if (matrix[i][q] > matrix[j][q]) {
                    flag = 0;
                }
            }
            if (flag == 1) {
                result.data[result.nums++] = new TripleNode(i, q, matrix[i][q]);
            }
        }
        for (int i = 0; i < result.nums; i++) {
            result.data[i].display();
        }
    }
}

class Result {
    public TripleNode data[];
    public int nums;//存放鞍点个数

    public Result(int maxSize) {
        data = new TripleNode[maxSize];
        nums = 0;
    }

}
