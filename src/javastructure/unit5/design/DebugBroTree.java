package javastructure.unit5.design;

import javastructure.unit5.CSTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DebugBroTree {
    private int leafNum = 0;
    private int deepth = 0;


    public static void main(String[] args) {
        CSTreeNode g = new CSTreeNode('G');
        CSTreeNode d = new CSTreeNode('D', g, null);
        CSTreeNode h = new CSTreeNode('H');
        CSTreeNode f = new CSTreeNode('F', h, null);
        CSTreeNode e = new CSTreeNode('E', null, f);
        CSTreeNode c = new CSTreeNode('C', null, d);
        CSTreeNode b = new CSTreeNode('B', e, c);
        CSTreeNode a = new CSTreeNode('A', b, null);

        CSTreeNode root = a;

        DebugBroTree debug = new DebugBroTree();
        debug.leafNum = 0;
        System.out.println("叶子数为：" + debug.countLeaf(root));
        System.out.println("深度为：" + debug.getDeepth(root));
        System.out.print("先根遍历（递归）：");
        debug.preRootTraverse(root);
        System.out.println();
        System.out.print("后根遍历（递归）：");
        debug.postRootTraverse(root);
        System.out.println();
        System.out.println("先根遍历（非递归）：" + debug.preTraverse(root).toString());
        System.out.println("后根遍历（非递归）：" + debug.postTraverse(root).toString());
    }

    public int countLeaf(CSTreeNode T) {
        if (T != null) {
            if (T.lChild == null && T.rBro == null) {
                leafNum++;
            }
            countLeaf(T.lChild);
            countLeaf(T.rBro);
        }
        return leafNum;
    }

    public int getDeepth(CSTreeNode T) {
        if (T != null) {
            int lDeep = getDeepth(T.lChild);
            int rDeep = getDeepth(T.rBro);
            return (lDeep > rDeep ? lDeep : rDeep) + 1;
        }
        return 0;
    }

    //先根遍历（递归）
    public void preRootTraverse(CSTreeNode T) {
        if (T != null) {
            System.out.print(T.data);
            preRootTraverse(T.lChild);
            preRootTraverse(T.rBro);
        }
    }

    //先根遍历（非递归）
    public List<Object> preTraverse(CSTreeNode T) {
        if (T == null) {
            return null;
        }
        List<Object> L = new ArrayList<>();
        Stack<CSTreeNode> S = new Stack<>();
        while (!S.isEmpty() || T != null) {
            while (T != null) {
                L.add(T.data);
                S.push(T);
                T = T.lChild;
            }
            if (!S.isEmpty()) {
                T = S.pop();
                T = T.rBro;
            }
        }
        return L;
    }

    //后根遍历（非递归）
    public List<Object> postTraverse(CSTreeNode T) {
        if (T == null) {
            return null;
        }
        List<Object> L = new ArrayList<>();
        Stack<CSTreeNode> S = new Stack<>();
        while (!S.isEmpty() || T != null) {
            while (T != null) {
                S.push(T);
                T = T.lChild;
            }
            if (!S.isEmpty()) {
                T = S.pop();
                L.add(T.data);
                T = T.rBro;
            }
        }
        return L;
    }

    //后根遍历（递归）
    public void postRootTraverse(CSTreeNode T) {
        if (T != null) {
            postRootTraverse(T.lChild);
            System.out.print(T.data);
            postRootTraverse(T.rBro);
        }
    }




}
