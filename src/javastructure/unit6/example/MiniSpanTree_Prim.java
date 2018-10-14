package javastructure.unit6.example;

import javastructure.unit6.MGraph;

public class MiniSpanTree_Prim {
    public static void main(String[] args) {

    }

    private class CloseEdge {
        Object adjVex;//该弧所指向的顶点位置
        int lowCost;

        public CloseEdge(Object adjVex, int lowCost) {
            this.adjVex = adjVex;
            this.lowCost = lowCost;
        }
    }

    public Object[][] Prim(MGraph G, Object u) {
        Object[][] tree = new Object[G.getVexNum() - 1][2]; //存储最小边
        CloseEdge[] closeEdges = new CloseEdge[G.getVexNum()];
        int k = G.locateVex(u);
        return tree;
    }
}
