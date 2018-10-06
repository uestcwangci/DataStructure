package javastructure.unit4;

public class CrossList {
    public int mu, nu, tu;//行数、列数、非零元素个数
    public OLNode[] rhead, chead;

    public CrossList(int mu, int nu) {
        this.mu = mu;
        this.nu = nu;
        rhead = new OLNode[mu];
        chead = new OLNode[nu];
        tu = 0;
        for (int i = 0; i < mu; i++) {
            rhead[i] = new OLNode();
        }
        for (int i = 0; i < nu; i++) {
            chead[i] = new OLNode();
        }
    }

    public void insert(int row, int col, int val) {//此处row为rhead[row - 1],col同理
        OLNode rTemp = rhead[row - 1];
        OLNode cTemp = chead[col - 1];
        OLNode current = new OLNode(row, col, val);
        OLNode oldTemp = null;
        if (rTemp.right == null) {
            rTemp.right = current;
        } else {
            while (rTemp.right != null) {
                oldTemp = rTemp;
                rTemp = rTemp.right;
                if (rTemp.col > col) {
                    oldTemp.right = current;
                    current.right = rTemp;
                    break;
                } else if (rTemp.col == col) {
                    System.out.println(rTemp.row + "行" + rTemp.col + "列已有元素");
                    return;
                } else if (rTemp.right == null) {
                    rTemp.right = current;
                    break;
                }
            }
        }
        if (cTemp.down == null) {
            cTemp.down = current;
//            tu++;
        } else {
            while (cTemp.down != null) {
                oldTemp = cTemp;
                cTemp = cTemp.down;
                if (cTemp.row > row) {
                    oldTemp.down = current;
                    current.down = cTemp;
                    break;
                } else if (cTemp.row == row) {
                    System.out.println(cTemp.row + "行" + cTemp.col + "列已有元素");
                    return;
                } else if (cTemp.down == null) {
                    cTemp.down = current;
                    break;
                }
            }
        }
        tu++;
    }

    public void display() {
        int[][] mat = new int[mu][nu];
        for (int i = 0; i < mu; i++) {
            OLNode temp = rhead[i].right;
            while (temp != null) {
                mat[temp.row - 1][temp.col - 1] = temp.e;
                temp = temp.right;
            }
        }
        for (int i = 0; i < mu; i++) {
            for (int j = 0; j < nu; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
