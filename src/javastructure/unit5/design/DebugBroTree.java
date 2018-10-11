package javastructure.unit5.design;

import javastructure.unit5.CSTreeNode;

public class DebugBroTree {
    public static void main(String[] args) {
        CSTreeNode d = new CSTreeNode('D');
        CSTreeNode g = new CSTreeNode('G');
        CSTreeNode h = new CSTreeNode('H');
        CSTreeNode e = new CSTreeNode('E', g, null);
        CSTreeNode f = new CSTreeNode('F', null, h);
        CSTreeNode b = new CSTreeNode('B', d, e);
        CSTreeNode c = new CSTreeNode('C', f, null);
        CSTreeNode a = new CSTreeNode('A', b, c);
    }


}
