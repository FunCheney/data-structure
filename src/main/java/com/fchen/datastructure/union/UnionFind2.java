package com.fchen.datastructure.union;

/**
 * @Classname UnionFind2
 * @Description 并查集实现方式二
 * @Date 2019/5/11 21:55
 * @Author by Chen
 */
public class UnionFind2 implements UF{
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
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
        parent[pRoot] = qRoot;

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
