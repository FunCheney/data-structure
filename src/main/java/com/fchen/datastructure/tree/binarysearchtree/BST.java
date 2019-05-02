package com.fchen.datastructure.tree.binarysearchtree;

/**
 * @Classname BST
 * @Description 二分搜索树实现类
 * @Date 2019/5/2 17:36
 * @Author by Chen
 */
public class BST<E extends Comparable<E>> {
    /**
     * 根节点
     */
    private Node<E> root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中加入元素
     * @param e
     */
    public void add(E e){
        if(root == null){
            root = new Node<>(e);
        }else{
            //从根节点开始添加元素
            add(root, e);
        }
    }

    private void add(Node node,E e){
        if(e.equals(node.e)){
            return;
        }else if(e.compareTo((E)node.e) < 0 && node.left == null ){
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo((E)node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }else{
            if(e.compareTo((E)node.e) < 0){
                add(node.left,e);
            }else{
                add(node.right,e);
            }
        }
    }
}
