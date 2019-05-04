package com.fchen.datastructure.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 二分搜索树非递归遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null){
                stack.push(cur.right);

            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
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

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小值
     * @return
     */
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        Node minimum = minimum(root);
        return (E)minimum.e;
    }

    /**
     * 返回以Node为根节点的二分搜索树的最小值所在节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大值
     * @return
     */
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        Node maximum = maximum(root);
        return (E)maximum.e;
    }

    public Node maximum(Node node){
        if(node.right == null){
           return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小值所在节点，返回最小值
     * @return
     */
    public E removeMin(){
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    /**
     * 删除以Node为根的二分搜索树的最小节点
     * 返回删除节点后二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    /**
     * 删除最大值所在节点，返回最大值
     * @return
     */
    public E removeMax(){
        E res = maximum();
        root = removeMax(root);
        return res;
    }
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除二分搜索树中的某一元素e
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除以Node为根的二分搜索树中值为e的节点
     * @param node
     * @param e
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo((E)node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo((E) node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else{
            //待删除的节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除的节点右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除的节点左右子树都不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树最小的节点
            //用这个节点代替 待删除的节点
            Node successor = minimum(node.right);
            successor.right = removeMax(node.right);
            size++;
            successor.left = node.left;
            node.left = node.right = null;
            size--;
            return successor;
        }
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
