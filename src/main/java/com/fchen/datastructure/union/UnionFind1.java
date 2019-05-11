package com.fchen.datastructure.union;

/**
 * @Classname UnionFind1
 * @Description 并查集实现方式1
 * @Date 2019/5/11 21:03
 * @Author by Chen
 */
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }

    }

    /**
     * 查看元素p与元素q是否在同一个集合中
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p yu元素q所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }
        for(int i = 0; i < id.length; i++){
            if(id[i] == pId){
                id[i] = qId;
            }
        }

    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合的编号
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p > id.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }
}
