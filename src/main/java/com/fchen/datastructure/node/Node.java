package com.fchen.datastructure.node;

/**
 * @Classname Node
 * @Description 节点结构类型
 * @Date 2019/5/2 16:40
 * @Author by Chen
 */
public class Node<E> {
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
