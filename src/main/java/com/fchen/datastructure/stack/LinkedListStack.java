package com.fchen.datastructure.stack;

import com.fchen.datastructure.linkedlist.LinkedList;

/**
 * @Classname LinkedListStack
 * @Description 使用链表实现栈结构
 * @Date 2019/5/2 15:23
 * @Author by Chen
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return (E)list.removeFirst();
    }

    @Override
    public E peek() {
        return (E)list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack Top: ");
        sb.append(list);
        return sb.toString();
    }
}
