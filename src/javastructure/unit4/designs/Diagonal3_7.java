package javastructure.unit4.designs;

public class Diagonal3_7 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,7,4,1},
                {4,8,3,6},
                {1,6,1,2},
                {0,7,8,9}};
        int[][] mat1 = new int[][]{
                {1,2,3,4,5},
                {2,3,4,5,6},
                {3,4,5,6,7},
                {4,5,6,7,8},
                {5,6,7,8,9},
        };
        Diagonal3_7 ex3_7 = new Diagonal3_7();
        ex3_7.matrixDiagonal(mat);
        ex3_7.matrixDiagonal(mat1);
    }



    private void matrixDiagonal(int[][] m) {
        int n = m.length;
        int result1 = 0;
        int result2 = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result1 += m[i][i];
            result2 += m[i][n - 1 - i];
        }
        result = result1 + result2;
        if (n % 2 == 0) {
            System.out.println("对角元和为: " + result);
        } else {//当n为奇，减去对角元重复的位置
            result -= m[n/2][n/2];
            System.out.println("对角元和为: " + result);
        }


    }
}
