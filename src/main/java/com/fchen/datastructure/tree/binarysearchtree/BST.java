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
        //从根节点开始添加元素
        root = add(root, e);
    }

    /**
     * 返回插入新节点后，二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo((E)node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo((E)node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 查看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 以node为根的二分搜索书中是否包含元素e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo((E)node.e) < 0){
            return contains(node.left, e);
        }else if(e.compareTo((E)node.e) > 0){
            return contains(node.right,e);
        }else{
            return true;
        }
    }

    /**
     * 前序遍历二叉树
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树
     * @param node
     */
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历二分搜索树
     * 中序遍历的结果是顺序的
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树
     * @param node
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历二分搜索树
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以Node为根节点 深度为depth 的二查搜索树的描述字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
