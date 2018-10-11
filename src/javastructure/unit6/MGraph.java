package javastructure.unit6;

import java.util.Scanner;

public class MGraph implements IGraph {
    private static final int INFINITY = Integer.MAX_VALUE;
    private GraphKind kind;
    private int vexNum, arcNum;//顶点数，边数
    private Object[] vexs;//顶点
    private int[][] arcs;//邻接矩阵

    public MGraph() {
        this(null, 0, 0, null, null);
    }

    public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
        this.arcs = arcs;
    }



    @Override
    public void createUDG() {

    }

    @Override
    public void createDG() {

    }


    //创建无向网
    @Override
    public void createUDN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入图的顶点数、边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new Object[vexNum];
        System.out.println("分别输入各个顶点：");
        for (int i = 0; i < vexNum; i++) {
            vexs[i] = sc.nextLine();
        }
        arcs = new int[vexNum][vexNum];
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                arcs[i][j] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点及其权值：");
        for (int i = 0; i < arcNum; i++) {
            int v = locateVex(sc.nextLine());
            int u = locateVex(sc.nextLine());
            arcs[u][v] = arcs[v][u] = sc.nextInt();
        }
    }
    //创建有向网
    @Override
    public void createDN() {

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
        return vexs[v];
    }
    //根据顶点定位在图中的位置
    @Override
    public int locateVex(Object vex) {
        for (int i = 0; i < vexNum; i++) {
            if (vexs[i].equals(vex)) {
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
        for (int i = 0; i < vexNum; i++) {
            if (arcs[v][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }
    //已知w是v的邻接点，找到相对w的v的下个邻接点
    @Override
    public int nextAdjVex(int v, int w) throws Exception {
        if (v < 0 || v >= vexNum) {
            throw new Exception("第" + v + "个顶点不存在");
        }
        for (int i = w + 1; i < vexNum; i++) {
            if (arcs[v][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    public GraphKind getKind() {
        return kind;
    }

    public Object[] getVexs() {
        return vexs;
    }

    public int[][] getArcs() {
        return arcs;
    }
}
