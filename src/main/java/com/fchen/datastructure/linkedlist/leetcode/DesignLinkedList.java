package com.fchen.datastructure.linkedlist.leetcode;

/**
 * @Classname DesignLinkedList
 * @Description 设计链表
 *
 * @Date 2019/6/14 15:25
 * @Author by Fchen
 */
public class DesignLinkedList {
    class Node{
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this(val,null);
        }
        public Node(){
        }
    }
    private Node head;

    private int size;

    /** InitializeMyLinkedList your data structure here. */
    public DesignLinkedList() {
        head = new Node(0);
        size = 0;
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node cur = head.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
       addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            return;
        }
        Node prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        prev.next = new Node(val,prev.next);
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size){
            return;
        }
        Node prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
    }
}
