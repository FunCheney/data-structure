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
     * 使用heapify 的方式创建堆
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        //第一个非叶子节点的索引
        int parent = parent(arr.length - 1);
        for(int i = parent; i >=0; i++){
            siftDown(i);
        }
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

    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("heap is empty");
        }
        return data.getIndex(0);
    }

    /**
     * 取出堆中的最大元素
     * @return
     */
    public E extractMax(){
        E res = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if((k + 1) < data.getSize() && data.getIndex(j + 1).compareTo(data.getIndex(j)) > 0){
                j = rightChild(k);
            }
            //data[j] 是 leftChild 和 rightChild 中的最大值
            if(data.getIndex(j).compareTo(data.getIndex(k)) >= 0){
                data.swap(k,j);
                k = j;
            }
        }
    }

    /**
     * 将堆中的最大元素取出，并加入一个新的元素
     * @param e
     * @return
     */
    public E repalce(E e){
        E ret = findMax();
        data.set(e,0);
        siftDown(0);
        return ret;
    }



}
