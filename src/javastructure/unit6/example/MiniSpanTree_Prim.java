package javastructure.unit6.example;

import javastructure.unit6.MGraph;

public class MiniSpanTree_Prim {
    public static void main(String[] args) throws Exception {
        MGraph mGraph = new MGraph();
        mGraph.createPrimGraph();
        MiniSpanTree_Prim debug = new MiniSpanTree_Prim();
        Object[][] tree = debug.Prim(mGraph, 'B');
        for (int i = 0; i < tree.length; i++) {
            System.out.println(tree[i][0] + " - " + tree[i][1]);
        }

    }

    private class CloseEdge {
        Object adjVex;//该弧所指向的顶点位置
        int lowCost;

        public CloseEdge(Object adjVex, int lowCost) {
            this.adjVex = adjVex;
            this.lowCost = lowCost;
        }
    }

    public Object[][] Prim(MGraph G, Object u) throws Exception {
        Object[][] tree = new Object[G.getVexNum() - 1][2]; //存储最小边
        CloseEdge[] closeEdges = new CloseEdge[G.getVexNum()];
        int k = G.locateVex(u);
        int count = 0;
        for (int i = 0; i < G.getVexNum(); i++) {
            closeEdges[i] = new CloseEdge(u, G.getArcs()[k][i]);
        }
        closeEdges[k] = new CloseEdge(u, 0);
        for (int i = 1; i < G.getVexNum(); i++) {//对剩下n-1个点做处理
            k = findMinEdg(closeEdges);
            tree[count][0] = closeEdges[k].adjVex;
            tree[count++][1] = G.getVex(k);
            closeEdges[k].lowCost = 0;
            for (int j = 0; j < G.getVexNum(); j++) {
                if (G.getArcs()[k][j] < closeEdges[j].lowCost) {
                    closeEdges[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
                }
            }

        }
        return tree;

    }

    private int findMinEdg(CloseEdge[] closeEdges) {
        int minNum = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i < closeEdges.length; i++) {
            if (closeEdges[i].lowCost != 0 && closeEdges[i].lowCost < minNum) {
                minNum = closeEdges[i].lowCost;
                v = i;
            }
        }
        return v;
    }
}
