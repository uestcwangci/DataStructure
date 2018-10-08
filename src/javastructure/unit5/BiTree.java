package javastructure.unit5;

import javastructure.unit3.queue.LinkQueue;
import javastructure.unit3.stack.LinkStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BiTree {
    public int count = 0;

    private BiTreeNode root;

    public BiTree() {
        this.root = null;
    }

    public BiTree(BiTreeNode root) {
        this.root = root;
    }
    //由先根遍历和中根遍历序列创建一棵二叉树的算法
    public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {

    }

    //由标明空子树的先根遍历序列创建一棵二叉树的算法
    private static int index = 0;

    public BiTree(String preStr) {

    }

    //先根遍历二叉树的递归算法
    public void preRootTraverse(BiTreeNode T) {
        if (T != null) {
            System.out.print(T.data);
            preRootTraverse(T.lChild);
            preRootTraverse(T.rChild);
        }
    }
    //先根遍历二叉树的非递归算法
    public void preRootTraverse() throws Exception {
        BiTreeNode T = root;
        if (T != null) {
            LinkStack S = new LinkStack();
            S.push(T);
            while (!S.isEmpty()) {
                T = (BiTreeNode) S.pop();
                System.out.print(T.data);
                while (T != null) {
                    if (T.lChild != null) {
                        System.out.print(T.lChild.data);
                    }
                    if (T.rChild != null) {
                        S.push(T.rChild);
                    }
                    T = T.lChild;
                }
            }
        }

    }
    //中根遍历二叉树的递归算法
    public void inRootTraverse(BiTreeNode T) {
        if (T != null) {
            inRootTraverse(T.lChild);
            System.out.print(T.data);
            inRootTraverse(T.rChild);
        }
    }
    //中根遍历二叉树的非递归算法
    public void inRootTraverse() throws Exception {
        BiTreeNode T = root;
        if (T != null) {
            LinkStack S = new LinkStack();
            S.push(T);
            while (!S.isEmpty()) {
                while (S.peek() != null) {
                    S.push(((BiTreeNode) S.peek()).lChild);
                }
                S.pop(); //弹出栈顶空结点
                if (!S.isEmpty()) {
                    T = (BiTreeNode) S.pop();
                    System.out.print(T.data);
                    S.push(T.rChild);
                }
            }
        }
    }
    //后根遍历二叉树的递归算法
    public void postRootTraverse(BiTreeNode T) {
        if (T != null) {
            postRootTraverse(T.lChild);
            postRootTraverse(T.rChild);
            System.out.print(T.data);
        }
    }
    //后根遍历二叉树的非递归算法
    public void postRootTraverse() throws Exception {
        BiTreeNode T = root;
        if (T != null) {
            LinkStack S = new LinkStack();
            S.push(T);
            Boolean flag = false;
            BiTreeNode p = null;
            while (!S.isEmpty()) {
                while (S.peek() != null) {
                    S.push(((BiTreeNode) S.peek()).lChild);
                }
                S.pop();
                while (!S.isEmpty()) {
                    T = (BiTreeNode) S.peek();
                    if (T.rChild == null || T.rChild == p) {
                        System.out.print(T.data);
                        S.pop();
                        p = T;
                        flag = true;

                    } else {
                        S.push(T.rChild);
                        flag = false;
                    }
                    if (!flag) {
                        break;
                    }
                }
            }
        }

    }
    //层级遍历二叉树的算法（从左向右）
    public void levelTraverse() throws Exception {
        BiTreeNode T = root;
        if (T != null) {
            LinkQueue Q = new LinkQueue();
            Q.offer(T);
            while (!Q.isEmpty()) {
                T = (BiTreeNode) Q.poll();
                System.out.print(T.data);
                if (T.lChild != null) {
                    Q.offer(T.lChild);
                }
                if (T.rChild != null) {
                    Q.offer(T.rChild);
                }
            }
        }
    }

    public BiTreeNode searchNode(BiTreeNode T, Object x) {
        if (T != null) {
            if (T.data.equals(x)) {
                return T;
            } else {
                BiTreeNode result = searchNode(T.lChild, x);
                return result == null ? searchNode(T.rChild, x) : result;
            }
        }
        return null;
    }

    public void countNode(BiTreeNode T) {
        if (T != null) {
            count++;
            countNode(T.lChild);
            countNode(T.rChild);
        }
    }

    public void countNode1(BiTreeNode T) throws Exception {
        if (T != null) {
            LinkQueue Q = new LinkQueue();
            Q.offer(T);
            while (!Q.isEmpty()) {
                T = (BiTreeNode) Q.poll();
                count++;
                if (T.lChild != null) {
                    Q.offer(T.lChild);
                }
                if (T.rChild != null) {
                    Q.offer(T.rChild);
                }
            }
        }
    }

    public List<Object> traverse(BiTreeNode root){
        List<Object> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<BiTreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.lChild;
            }
            BiTreeNode t = s.pop();
            list.add(t.data);
            root = t.rChild;
        }
        return list;
    }

    public int getDepth(BiTreeNode T) {
        if (T != null) {
            int lDepth = getDepth(T.lChild);
            int rDepth = getDepth(T.rChild);
            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }
        return 0;
    }

    public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }
        if (T1 != null && T2 != null) {
            if (T1.data == T2.data) {
                if (isEqual(T1.lChild, T2.lChild)) {
                    if (isEqual(T1.rChild, T2.rChild)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }
}
