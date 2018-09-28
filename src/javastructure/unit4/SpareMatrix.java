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

    public void printMartrix() {
        int i;
        System.out.println("行数：" + rows + ", 列数：" + columns + "， 非零元素个数：" + nums);
        System.out.println("行\t列\t值");
        for (i = 0; i < nums; i++) {
            System.out.println(data[i].row + "\t" + data[i].column + "\t" + data[i].value);
        }
    }
}
