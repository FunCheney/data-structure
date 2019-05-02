package com.fchen.datastructure.tree.binarysearchtree;

/**
 * @Classname Node
 * @Description 二分搜索树节点类
 * @Date 2019/5/2 17:37
 * @Author by Chen
 */
public class Node<E extends Comparable<E>>{
    private E e;
    /**
     * 左节点
     */
    private Node left;
    /**
     * 右节点
     */
    private Node right;

    public Node(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }
}
