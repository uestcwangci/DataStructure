package javastructure.unit4;

public class SpareMatrix {
    public TripleNode data[];
    public int rows;
    public int columns;
    public int nums;

    public SpareMatrix(int maxSize) {
        data = new TripleNode[maxSize];
        for (int i = 0; i < data.length; i++) {
            data[i] = new TripleNode();
        }
        rows = 0;
        columns = 0;
        nums = 0;
    }



    public SpareMatrix(int[][] mat) {
        this.rows = mat.length;
        this.columns = mat[0].length;
        this.nums = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] != 0) {
                    this.nums++;
                }
            }
        }
        data = new TripleNode[nums];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] != 0) {
                    data[k] = new TripleNode(i, j, mat[i][j]);
                    k++;
                }
            }
        }
    }

    public void printMatrix() {
        System.out.println("行数：" + rows + ", 列数：" + columns + "， 非零元素个数：" + nums);
        System.out.println("行\t列\t值");
        for (int i = 0; i < nums; i++) {
            System.out.println((data[i].row) + "\t" + (data[i].column) + "\t" + data[i].value);
        }
    }
}
