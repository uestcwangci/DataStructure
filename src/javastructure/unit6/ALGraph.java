package javastructure.unit6;

import java.util.Scanner;

public class ALGraph implements IGraph {
    private GraphKind kind;
    private int vexNum;
    private int ArcNum;
    private VNode[] vexs;

    public ALGraph() {
        this(null, 0, 0, null);
    }

    public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.ArcNum = arcNum;
        this.vexs = vexs;
    }

    @Override
    public void createGraph() {
    }

    @Override
    public void createUDG() {

    }

    @Override
    public void createDG() {

    }

    @Override
    public void createUDN() {

    }

    @Override
    public void createDN() {

    }


    @Override
    public int getVexNum() {
        return 0;
    }

    @Override
    public int getArcNum() {
        return 0;
    }

    @Override
    public Object getVex(int v) throws Exception {
        return null;
    }

    @Override
    public int locateVex(Object vex) {
        return 0;
    }

    @Override
    public int firstAdjVex(int v) throws Exception {
        return 0;
    }

    @Override
    public int nextAdjVex(int v, int w) throws Exception {
        return 0;
    }
}
