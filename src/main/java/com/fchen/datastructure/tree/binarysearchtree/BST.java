package com.fchen.datastructure.tree.binarysearchtree;

/**
 * @Classname BST
 * @Description 二分搜索树实现类
 * @Date 2019/5/2 17:36
 * @Author by Chen
 */
public class BST<E extends Comparable<E>> {
    /**
     * 根节点
     */
    private Node<E> root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
