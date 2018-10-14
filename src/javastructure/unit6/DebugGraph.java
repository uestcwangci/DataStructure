package javastructure.unit6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DebugGraph {
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        MGraph mGraph = new MGraph();
        mGraph.createUDG();
        ALGraph alGraph = new ALGraph();
        alGraph.createUDG();
        BFSTraverse(mGraph);
        System.out.println();
        BFSTraverse(alGraph);
        System.out.println();
        DFSTraverse(mGraph);
        System.out.println();
        DFSTraverse(alGraph);
    }

    private static void BFSTraverse(IGraph G) throws Exception {
        visited = new boolean[G.getVexNum()];
        for (int i = 0; i < G.getVexNum(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < G.getVexNum(); i++) {
            if (!visited[i]) {
                BFS(G, i);
            }
        }
    }

    private static void BFS(IGraph G, int i) throws Exception  {
        visited[i] = true;
        System.out.print(G.getVex(i) + " ");
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(i);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)) {
                if (!visited[w]) {
                    visited[w] = true;
                    System.out.print(G.getVex(w) + " ");
                    Q.offer(w);
                }
            }
        }
    }

    private static void DFSTraverse(IGraph G) throws Exception {
        visited = new boolean[G.getVexNum()];
        for (int i = 0; i < G.getVexNum(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < G.getVexNum(); i++) {
            if (!visited[i]) {
                DFS(G, i);
            }
        }
    }

    private static void DFS(IGraph G, int v) throws Exception {
        visited[v] = true;
        System.out.print(G.getVex(v) + " ");
        for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w)) {
            if (!visited[w]) {
                DFS(G, w);
            }
        }
    }

}
