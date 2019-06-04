package com.fchen.datastructure.linkedlist;

/**
 * @Classname CircularLinkedList
 * @Description  循环链表
 * @Date 2019/5/26 23:24
 * @Author by Fchen
 */
public class CircularLinkedList<E> {

    private class Node{
        public E key;
        /**
         * 指向下一结点
         */
        private Node next;
        /**
         * 指向前一结点
         */
        private Node prev;

        public Node() {
            this(null,null,null);
        }

        public Node(E e){
            this(e, null, null);
        }

        public Node(E key, Node next, Node prev) {
            this.key = key;
            this.next = next;
            this.prev = prev;
        }
    }

    // 哨兵结点
    private Node nil;
    // 链表的长度
    private int size;

    public CircularLinkedList() {
        nil = new Node(null,nil,nil);
        size = 0;
    }

    private int getSize(){
        return size;
    }

    /**
     * 在双向循环链表头中加入元素e
     * @param e
     */
    public void addKey(E e){
        Node insertNode = new Node(e);
        insertNode.next = nil.next;
        nil.next.prev = insertNode;
        nil.next = insertNode;
        insertNode.prev = nil;
    }
}
