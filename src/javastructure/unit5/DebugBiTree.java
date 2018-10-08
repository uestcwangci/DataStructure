package javastructure.unit5;

import java.lang.reflect.Array;

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
