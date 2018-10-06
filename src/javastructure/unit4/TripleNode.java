package javastructure.unit4;

public class TripleNode {
    public int row;
    public int column;
    public int value;

    public TripleNode(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public TripleNode() {
        this(0, 0, 0);
    }

    public void display() {
        System.out.println("row: " + (this.row + 1) + "\tcolumn: " + (this.column + 1) + "\tvalue: " + this.value);
    }
}
