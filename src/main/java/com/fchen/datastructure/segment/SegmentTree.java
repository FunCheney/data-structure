package com.fchen.datastructure.segment;

/**
 * @Classname SegmentTree
 * @Description 线段树
 * @Date 2019/5/8 8:04
 * @Author by Chen
 */
public class SegmentTree<E> {
    private E[] data;

    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        data = (E[]) new Object[data.length];
        tree = (E[]) new Object[4 * data.length];
        for(int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        this.merger = merger;
        buildSegmentTree(0,0,data.length - 1);
    }

    /**
     * 在treeIndex 创建区间[L...R]的线段树
     * @param treeIndex
     * @param L
     * @param R
     */
    private void buildSegmentTree(int treeIndex,int L, int R){

        if(L == R){
            tree[treeIndex] = data[L];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = L  + (R - L) / 2;

        buildSegmentTree(leftTreeIndex, L, mid);
        buildSegmentTree(rightTreeIndex,mid + 1, R);

        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E getIndex(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("index Illegal");
        }
        return data[index];
    }

    /**
     * 返回区间[queryL...queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length){
            throw new IllegalArgumentException("Illegal segment");
        }
        return query(0,0,data.length - 1, queryL, queryR);
    }

    /**
     * 在treeIndex 为根的线段树中[L...R] 的范围内，搜索区间[queryL...queryR]的值
     * @param treeIndex
     * @param L
     * @param R
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex,int L, int R, int queryL, int queryR){
        if(L == queryL && R == queryR){
            return tree[treeIndex];
        }

        int mid = L + (R - L) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex= rightChild(treeIndex);
        if(queryL > mid + 1){
            return query(rightTreeIndex, mid + 1, R, queryL, queryR);
        }else if(queryL <= mid){
            return query(leftTreeIndex, L, mid, queryL, queryR);
        }else{
            E leftResult = query(leftTreeIndex, L, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, R, mid + 1, queryR);
            return merger.merger(leftResult,rightResult);
        }

    }

    public int getSize(){
        return data.length;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }
}
