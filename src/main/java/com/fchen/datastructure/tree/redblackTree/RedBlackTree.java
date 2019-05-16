package com.fchen.datastructure.tree.redblackTree;

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

    public int getSize(){
        return size;
    }

    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }

    //左旋转
    private Node leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }
    //右旋转
    private Node rightRotate(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    //颜色翻转
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    /**
     * 向红黑树中添加元素
     * @param key
     * @param value
     */
    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    /**
     * 向以Node 为根的红黑树中添加元素(key,value),返回插入新节点后，红黑树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node,K key, V value){
        if(node == null){
            size++;
            //默认插入红色节点
            return new Node(key,value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else{
            node.value = value;
        }
        if(isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }
}
