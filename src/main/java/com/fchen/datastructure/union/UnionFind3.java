package com.fchen.datastructure.union;

/**
 * @Classname UnionFind3
 * @Description 并查集实现方式三
 * @Date 2019/5/11 21:55
 * @Author by Chen
 */
public class UnionFind3 implements UF{
    private int[] parent;

    /**
     * sz[i] 表示以i为根的元素集合中的个数
     */
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        //根据两个元素所在树的元素个数不同判断合并方向
        //将元素个数少的集合合并到元素个数多的集合上
        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }


    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程，查找元素p对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }
}
