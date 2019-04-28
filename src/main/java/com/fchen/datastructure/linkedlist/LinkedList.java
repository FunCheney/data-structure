package com.fchen.datastructure.linkedlist;

/**
 * @Classname LinkedList
 * @Description 链表类
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
}
