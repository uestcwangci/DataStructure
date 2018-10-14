package javastructure.unit6;

import java.util.Scanner;

public interface IGraph {
    default void createGraph(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入图的类型（UDG, DG, UDN, UND):");
        GraphKind kind = GraphKind.valueOf(sc.nextLine());
        switch (kind) {
            case DG:
                createDG();
                return;
            case UDG:
                createUDG();
                return;
            case DN:
                createDN();
                return;
            case UDN:
                createUDN();
                return;
            default:
                return;
        }
    };

    //创建无向图
    void createUDG();

    //创建有向图
    void createDG();

    //创建无向网
    void createUDN();

    //创建有向网
    void createDN();

    int getVexNum();

    int getArcNum();

    Object getVex(int v) throws Exception;

    int locateVex(Object vex);

    int firstAdjVex(int v) throws Exception;

    int nextAdjVex(int v, int w) throws Exception;
}
