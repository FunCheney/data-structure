package com.fchen.datastructure.tree.avltree;

import java.util.ArrayList;

/**
 * @Classname AVLTree
 * @Description 平衡搜索树
 * @Date 2019/5/12 14:49
 * @Author by Chen
 */
public class AVLTree <K extends Comparable<K>,V>{
    public class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;
    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取Node节点的高度
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 获取节点Node的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //RR
    private Node rightRotate(Node y){

        Node x = y.left;
        Node t3 = x.right;

        //向右旋转的过程
        x.right = y;
        y.left = t3;
        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x;
    }

    //LL
    private Node leftRotate(Node y){

        Node x = y.right;
        Node t3 = x.left;

        //向右旋转的过程
        x.left = y;
        y.right = t3;
        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x;
    }

    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        //中序遍历
        inOrder(root,keys);
        for(int i = 0; i < keys.size(); i++){
            if(keys.get(i - 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断该二叉树是否为一棵平衡二叉树
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            return false;
        }else{
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }
    private void inOrder(Node node,ArrayList<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    public void add( K key, V value){
        root = add(root,key,value);
    }
    private Node add(Node node,K key,V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key,value);
        }else{
            node.value = value;
        }
        //更新height
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        //平衡维护
        if(Math.abs(balanceFactor) > 1 && getBalanceFactor(node.left) >=0){
            return rightRotate(node);
        }
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        //LR
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

}
