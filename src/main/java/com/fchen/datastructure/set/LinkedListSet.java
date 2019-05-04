package com.fchen.datastructure.set;

import com.fchen.datastructure.linkedlist.LinkedList;

/**
 * @Classname LinkedListSet
 * @Description 基于链表实现集合
 * @Date 2019/5/4 22:14
 * @Author by Chen
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        //删除链表中 的元素
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
