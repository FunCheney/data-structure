package com.fchen.datastructure.linkedlist;

/**
 * @Classname SingleCircularLinkedList
 * @Description 单向循环列表
 * @Date 2019/6/17 22:30
 * @Author by Chen
 */
public class SingleCircularLinkedList<E> {
    private class Node{
        public E key;
        public Node next;
        public Node(E key,Node next){
            this.key = key;
            this.next = next;
        }
        public Node(){
            this(null,null);
        }
        public Node(E key){
            this(key,null);
        }
    }

    private Node sentinel = new Node();

    //添加节点
    public void add(E key){
        Node curNode = new Node(key);
        if(sentinel.next == null){
            curNode.next = sentinel;
            sentinel.next = curNode;
        }else{
            Node first = sentinel.next;
            curNode.next = first;
            sentinel.next = curNode;
        }
    }
    //遍历当前环形链表
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(sentinel.key);
        Node curNode = sentinel.next;
        if(sentinel.next == null){
            return null;
        }
        while (!curNode.equals(sentinel)){
            sb.append("-->").append(curNode.key).append("-->");
            curNode = curNode.next;
        }
        sb.append(sentinel.key);
        return sb.toString();
    }

}
