package com.fchen.datastructure.set;

import com.fchen.datastructure.tree.binarysearchtree.BST;

/**
 * @Classname BSTSet
 * @Description 基于二分搜索树实现集合类
 * @Date 2019/5/4 12:06
 * @Author by Chen
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E o) {
        bst.add(o);
    }

    @Override
    public void remove(E o) {
        bst.remove(o);
    }

    @Override
    public boolean contains(E o) {
        return bst.contains(o);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
