package com.fchen.datastructure.queue;

import com.fchen.datastructure.node.Node;

/**
 * @Classname LinkedListQueue
 * @Description 使用链表实现队列
 * @Date 2019/5/2 16:36
 * @Author by Chen
 */
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 头节点
     */
    private Node<E> head;

    /**
     * 尾节点
     */
    private Node<E> tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node<>(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        Node deNode = head;
        head = head.next;
        deNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return (E)deNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue Front: ");
        Node cur = head;
        while (cur != null){
            sb.append(cur + "-->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
