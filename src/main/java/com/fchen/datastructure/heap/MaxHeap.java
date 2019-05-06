package com.fchen.datastructure.heap;

import com.fchen.datastructure.array.Array;

/**
 * @Classname MaxHeap
 * @Description 最大堆
 * @Date 2019/5/6 23:01
 * @Author by Chen
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 堆中有多少个元素
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树 数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("illegal index");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树 数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树 数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
      while (k > 0 && data.getIndex(parent(k)).compareTo(data.getIndex(k)) < 0){
            data.swap(k,parent(k));
            k = parent(k);
      }
    }

}
