package com.fchen.datastructure.linkedlist;

/**
 * @Classname DoublyLinkedList
 * @Description 双向链表实现
 * @Date 2019/5/25 21:32
 * @Author by Chen
 */
public class DoublyLinkedList<E> {

    private class Node{
        public E e;
        public Node next;
        public Node prev;

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node(E e) {
            this(e,null,null);
        }

        public Node(){
            this(null,null,null);
        }
    }


}
