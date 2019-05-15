package com.fchen.datastructure.tree.redblackTree;

import com.fchen.datastructure.tree.avltree.BST;

/**
 * @Classname RedBlackTree
 * @Description 红黑树
 * @Date 2019/5/15 8:31
 * @Author by Chen
 */
public class RedBlackTree<K extends Comparable<K>,V>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;
    public RedBlackTree() {
        root = null;
        size = 0;
    }
}
