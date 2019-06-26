package com.fchen.datastructure.tree.avltree;

/**
 * @Classname BST
 * @Description 二分搜索树
 * @Date 2019/5/13 7:32
 * @Author by Chen
 */
public class BST<K extends Comparable<K>,V>{
    public class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
}
