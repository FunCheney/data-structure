package com.fchen.datastructure.linkedlist;

/**
 * @Classname LinkedList
 * @Description 链表 单链表
 * @Date 2019/4/27 21:02
 * @Author by Chen
 */
public class LinkedList<E> {
    /**
     * 链表内部的节点类
     */
    private class Node{
        /**
         * 元素
         */
        public E e;
        /**
         * 下一节点
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public  Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟的头结点
     */
    private Node dummyHead;

    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 链表大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Index Illegal");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e,prev.next);
        size++;
    }

    /**
     * 链表头添加元素
     * @param e
     */
    public void addFirst(E e){
//        Node node = new Node(e,null);
//        node.next = head;
//        head = node;
        add(0,e);
    }

    /**
     * 链表末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e == e){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除节点
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size - 1);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for( Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur + "-->");
        }
        res.append("NULL");
        return res.toString();
    }
}
