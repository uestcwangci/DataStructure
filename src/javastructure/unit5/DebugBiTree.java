package javastructure.unit5;

import java.lang.reflect.Array;
import java.util.Stack;

public class DebugBiTree {
    public static void main(String[] args) throws Exception {
        DebugBiTree debug = new DebugBiTree();
        BiTree tree = debug.createBiTree();
        BiTreeNode root = tree.getRoot();
        //先根
        System.out.print("(递归)先根遍历序列为：");
        tree.preRootTraverse(root);
        System.out.println();
        System.out.print("(非递归)先根遍历序列为：");
        tree.preRootTraverse();
        System.out.println();
        //中根
        System.out.print("(递归)中根遍历序列为：");
        tree.inRootTraverse(root);
        System.out.println();
        System.out.print("(非递归)中根遍历序列为：");
        tree.inRootTraverse();
        System.out.println();
        //后根
        System.out.print("(递归)后根遍历序列为：");
        tree.postRootTraverse(root);
        System.out.println();
        System.out.print("(非递归)后根遍历序列为：");
        tree.postRootTraverse();
        System.out.println();
        //层次
        System.out.print("层次遍历序列为：");
        tree.levelTraverse();
        System.out.println();
        //计数
        tree.count = 0;
        tree.countNode(root);
        System.out.println(tree.count);
        //遍历
        System.out.println(tree.traverse(root).toString());
        //寻找结点
        System.out.println(tree.searchNode(root, 'F').data);
        //计数
        tree.count = 0;
        tree.countNode1(root);
        System.out.println(tree.count);
        //深度
        System.out.println("深度:" + tree.getDepth(root));
        //先根+中根创建树
        String preOrder = "ABDEGCFH";
        String inOrder = "DBGEAFHC";
        BiTree tree1 = new BiTree(preOrder, inOrder, 0, 0, preOrder.length(), true);
        System.out.print("后根遍历为：");
        tree1.postRootTraverse();
        String postOrder = "DGEBHFCA";
        BiTree tree1Bro = new BiTree(postOrder, inOrder, preOrder.length() - 1, 0, postOrder.length(), false);
        System.out.println();
        System.out.print("先根遍历为：");
        tree1Bro.preRootTraverse();
        //已知空节点建立树
        String preStr = "AB##CD###";
        BiTree tree2 = new BiTree(preStr);
        System.out.println();
        System.out.print("先根遍历：");
        tree2.preRootTraverse();
        //完全二叉树
        String completeStr = "ABCDEFGH";
        BiTreeNode compleRoot = new BiTree().creatCompleteTree(completeStr, 0);
        BiTree tree3 = new BiTree(compleRoot);
        System.out.println();
        System.out.print("先根：");
        tree3.preRootTraverse();
        //双栈实现后根遍历
        BiTree tree4 = debug.createBiTree();
        Stack doubleS = tree4.postDoubleStack(tree4.getRoot());
        System.out.println();
        while (!doubleS.isEmpty()) {
            System.out.print(doubleS.pop());
        }
        //堆栈实现层次遍历
        System.out.println();
        tree.levelStack(root);
    }

    private BiTree createBiTree() {
        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode g = new BiTreeNode('G');
        BiTreeNode h = new BiTreeNode('H');
        BiTreeNode e = new BiTreeNode('E', g, null);
        BiTreeNode f = new BiTreeNode('F', null, h);
        BiTreeNode b = new BiTreeNode('B', d, e);
        BiTreeNode c = new BiTreeNode('C', f, null);
        BiTreeNode a = new BiTreeNode('A', b, c);
        return new BiTree(a);
    }
}
