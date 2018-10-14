package javastructure.unit6;

import javafx.scene.shape.Arc;

import java.util.Scanner;

public class ALGraph implements IGraph {
    private GraphKind kind;
    private int vexNum;
    private int arcNum;
    private VNode[] vexs;
    boolean[] isVisited;

    public ALGraph() {
        this(null, 0, 0, null);
    }

    public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
    }


    @Override
    public void createUDG() {
        vexNum = 5;
        arcNum = 5;
        vexs = new VNode[vexNum];
        char c = 'A';
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(c++);
        }
        addArc(0, 1, 1);
        addArc(1, 0, 1);
        addArc(1, 2, 1);
        addArc(2, 1, 1);
        addArc(1, 4, 1);
        addArc(4, 1, 1);
        addArc(2, 3, 1);
        addArc(3, 2, 1);
        addArc(3, 4, 1);
        addArc(4, 3, 1);
    }

    @Override
    public void createDG() {
        vexNum = 5;
        arcNum = 4;
        vexs = new VNode[vexNum];
        char c = 'A';
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(c++);
        }
        addArc(0, 1, 1);
        addArc(0, 2, 1);
        addArc(3, 0, 1);
        addArc(3, 4, 1);

    }

    @Override
    public void createUDN() {
        vexNum = 7;
        arcNum = 7;
        vexs = new VNode[vexNum];
        char c = 'A';
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(c++);
        }
        addArc(0, 1, 10);
        addArc(1, 0, 10);
        addArc(0, 2, 2);
        addArc(2, 0, 2);
        addArc(1, 3, 7);
        addArc(3, 1, 7);
        addArc(1, 5, 5);
        addArc(5, 1, 5);
        addArc(3, 4, 2);
        addArc(4, 3, 2);
        addArc(4, 5, 5);
        addArc(5, 4, 5);

    }


    @Override
    public void createDN() {
        vexNum = 4;
        arcNum = 4;
        vexs = new VNode[vexNum];
        char c = 'A';
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(c++);
        }

        addArc(0, 1, 1);
        addArc(0, 2, 4);
        addArc(2, 3, 7);
        addArc(3, 0, 6);
        addArc(2, 2, 4);

    }
    //在v，u之间添加一条弧。权值为value
    public void addArc(int v, int u, int value) {
        ArcNode arc = new ArcNode(u, value);
        arc.nextArc = vexs[v].firstArc;
        vexs[v].firstArc = arc;
    }

    public void createCircleUDG() {
        vexNum = 7;
        arcNum = 6;
        vexs = new VNode[vexNum];
        char c = 'A';
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = new VNode(c++);
        }
        addArc(0, 1, 1);
        addArc(1, 0, 1);
        addArc(0, 2, 1);
        addArc(2, 0, 1);
        addArc(0, 3, 1);
        addArc(3, 0, 1);
        addArc(2, 3, 1);
        addArc(3, 2, 1);
        addArc(4, 5, 1);
        addArc(5, 4, 1);
        addArc(4, 6, 1);
        addArc(6, 4, 1);
        addArc(5, 6, 1);
        addArc(6, 5, 1);
    }

    public void displaySeq() throws Exception {
        isVisited = new boolean[vexNum];
        int count = 1;
        for (int i = 0; i < vexNum; i++) {
            isVisited[i] = false;
        }
        for (int i = 0; i < vexNum; i++) {
            if (!isVisited[i]) {
                System.out.println();
                System.out.println("第" + (count++) + "个连通分支：");
                System.out.print(getVex(i) + " ");
                isVisited[i] = true;
                for (ArcNode arcNode = vexs[i].firstArc; arcNode != null; arcNode = arcNode.nextArc) {
                    int k = arcNode.adjVex;
                    if (!isVisited[k]){
                        System.out.print(vexs[k].data + " ");
                        isVisited[k] = true;
                    }
                }
            }
        }
    }

    public void hasPath(Object u, Object v) throws Exception {
        int k = locateVex(u);
        int l = locateVex(v);
        isVisited[k] = true;
        for (int w = firstAdjVex(k); w >= 0; w = nextAdjVex(k, w)) {
            if (w == l) {
                System.out.println("存在");
            } else if (!isVisited[w]) {
                hasPath(getVex(w), v);
            }
        }
    }

    @Override
    public int getVexNum() {
        return vexNum;
    }

    @Override
    public int getArcNum() {
        return arcNum;
    }

    @Override
    public Object getVex(int v) throws Exception {
        if (v < 0 || v >= vexNum) {
            throw new Exception("第" + v + "个顶点不存在");
        }

        return vexs[v].data;
    }

    @Override
    public int locateVex(Object vex) {
        for (int i = 0; i < vexNum; i++) {
            if (vexs[i].data.equals(vex)) {
                return i;
            }
        }
        return -1;
    }
    //查找第v个节点的第一个邻接点
    @Override
    public int firstAdjVex(int v) throws Exception {
        if (v < 0 || v >= vexNum) {
            throw new Exception("第" + v + "个顶点不存在");
        }
        if (vexs[v].firstArc != null) {
            return vexs[v].firstArc.adjVex;
        }
        return -1;
    }

    @Override
    public int nextAdjVex(int v, int w) throws Exception {
        if (v < 0 || v >= vexNum) {
            throw new Exception("第" + v + "个顶点不存在");
        }
        VNode vex = vexs[v];
        ArcNode arcvw = null;
        for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc) {
            if (arc.adjVex == w) {
                arcvw = arc;
                break;
            }
        }
        if (arcvw != null && arcvw.nextArc != null) {
            return arcvw.nextArc.adjVex;
        } else {
            return -1;
        }
    }

    public void insertArc(int u, int v) {//在u，v之间插入一条弧
        ArcNode arcNode = new ArcNode(v, 1);
        arcNode.nextArc = vexs[u].firstArc;
        vexs[u].firstArc = arcNode;
    }

    public void deleteArc(int u, int v) throws Exception {//在u，v之间删除一条弧
        for (ArcNode arc = vexs[u].firstArc; arc != null; arc = arc.nextArc) {
            if (arc.adjVex == v) {
                arc.adjVex = arc.nextArc.adjVex;
            }
        }
        throw new Exception(u + " " + v + "之间无连接");

    }
}
