package javastructure.unit5;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] W = {23, 11, 5, 3, 29, 14, 7, 8};
        HuffmanTree T = new HuffmanTree();
        int[][] HN = T.huffmanCoding(W);
        System.out.println("哈夫曼编码为：");
        for (int i = 0; i < HN.length; i++) {
            System.out.print(W[i] + " ");
            for (int j = 0; j < HN[i].length; j++) {
                if (HN[i][j] == -1) {
                    for (int k = j + 1; k < HN[i].length; k++) {
                        System.out.print(HN[i][k]);
                    }
                    break;
                }
            }
            System.out.println();
        }
    }

    private int[][] huffmanCoding(int[] W) {
        int n = W.length;
        int m = 2 * n - 1;//哈夫曼树节点数
        HuffmanNode[] HN = new HuffmanNode[m];
        for (int i = 0; i < n; i++) {
            HN[i] = new HuffmanNode(W[i]);
        }
        for (int i = n; i < m; i++) {
            HuffmanNode min1 = selectMin(HN, i - 1);//在[0, i-1]中找到最小的两个节点
            min1.flag = 1;
            HuffmanNode min2 = selectMin(HN, i - 1);
            min2.flag = 1;
            HN[i] = new HuffmanNode();
            min1.parent = HN[i];
            min2.parent = HN[i];
            HN[i].lChird = min1;
            HN[i].rChird = min2;
            HN[i].weight = min1.weight + min2.weight;
        }

        int[][] HuffCode = new int[n][n];
        for (int i = 0; i < n; i++) {
            int start = n - 1;
            for (HuffmanNode temp = HN[i], p = temp.parent; p != null; temp = p, p = p.parent) {
                if (p.lChird.equals(temp)) {
                    HuffCode[i][start--] = 0;//左孩子赋0
                } else {
                    HuffCode[i][start--] = 1;//右孩子赋1
                }
            }
            HuffCode[i][start] = -1;//标志位
        }

        return HuffCode;
    }

    private HuffmanNode selectMin(HuffmanNode[] HN, int end) {
        HuffmanNode min = HN[end];
        for (int i = 0; i < end; i++) {
            if (HN[i].flag == 0 && HN[i].weight < min.weight) {
                min = HN[i];
            }
        }
        return min;
    }

}
