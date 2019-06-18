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

    private Node sentinel;

    private int size;

    public SingleCircularLinkedList() {
        sentinel = new Node(null,null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

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
        size++;
    }

    /**
     * 在某一索引的位置添加关键字为key的结点
     * @param index
     * @param key
     */
    public void addIndex(int index, E key){
        if(index < 0 || index > size){
            throw new RuntimeException("index is Illegal");
        }
        Node insertNode = new Node(key);
        Node curNode = sentinel;
        for(int i = 0; i < index; i++){
            curNode = curNode.next;
        }
        insertNode.next = curNode.next;
        curNode.next = insertNode;
        size++;
    }
    @Override
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
