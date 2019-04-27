package com.fchen.datastructure.stack;

import com.fchen.datastructure.array.Array;

/**
 * @Classname ArrayStack
 * @Description 基于动态数组的实现创建的Stack类
 * @Date 2019/4/27 16:57
 * @Author by Chen
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Statck");
        sb.append('[');
        for(int i = 0; i < array.getSize(); i++){
            sb.append(array.getIndex(i));
            if(i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
