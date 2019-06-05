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
        public Node next;
        /**
         * 指向前一结点
         */
        public Node prev;

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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(prev != null){
                sb.append(prev.key);
            }else{
                sb.append(prev);
            }
            sb.append(" | ");
            if(key != null){
                sb.append(key.toString());
            }else{
                sb.append(key);
            }
            sb.append(" | ");
            if(next != null){
                sb.append(next.key).append("]");
            }else{
                sb.append(next).append("]");
            }
            return sb.toString();
        }
    }

    // 哨兵结点
    private Node nil;

    // 链表的长度
    private int size;

    public CircularLinkedList() {
       Object key = "sentinel";
        nil = new Node((E)key,null,null);
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
        //要插入的结点
        Node insertNode = new Node(e);
        //要插入结点的下一结点 为 nil 的next结点
        insertNode.next = nil.next;
        insertNode.prev = nil;
        nil.next = insertNode;
        if(insertNode.next != null){
            insertNode.next.prev = insertNode;
        }

        size++;
    }

    public void addIndex(int index){

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\r\n");
        for(Node cur = nil; cur != null; cur = cur.next){
            res.append(cur).append("--");
        }
//        res.append("N");
        return res.toString();
    }
}
