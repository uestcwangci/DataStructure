package javastructure.unit4.examples;

public class Magic {
    public static void main(String[] args) {
        Magic m = new Magic();
        m.createMagic(4);
    }

    private void createMagic(int n) {
        int mat[][] = new int[n][n];
        int row = 0;
        int col = n / 2;
        for (int k = 0; k <= n * n; k++) {
            mat[row][col] = k;//第一个元素放在(0,n/2)位置上
            if (k % n == 0) {//下一个位置有值
                row = (row + 1) % n;
            } else {
                row = (row - 1 + n) % n;
                col = (col + 1 + n) % n;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
