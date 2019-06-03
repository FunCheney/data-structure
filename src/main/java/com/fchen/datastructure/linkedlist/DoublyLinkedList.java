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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if(prev != null){
                sb.append("[").append(prev.e);
            }
            sb.append(" | ");
            if(e != null){
               sb.append(e.toString());
            }else{
                sb.append("null");
            }
            sb.append(" | ");
            if(next != null){
                sb.append(next.e).append("]");
            }else{
               sb.append("null").append("]");
            }
            return sb.toString();
        }
    }

    private Node dummyHead;

    private int size;

    public DoublyLinkedList(){
        dummyHead = new Node(null,null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 在双向链表的任意位置添加元素
     * @param index 要添加元素的位置
     * @param e   要添加的结点的关键字
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Illegal Index");
        }
        Node cur = dummyHead;
        if(index > 0){
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            cur.next = new Node(e,cur.next,cur);
        }else{
            Node insertNode = new Node(e,cur.next,cur);
            cur.next = insertNode;
            cur = insertNode.next;
            if(cur != null){
                cur.prev = insertNode;
            }
        }
        size++;
    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在链表尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在链表中查找关键字所在的第一个结点
     * @param e 关键字可以
     * @return
     */
    public Node searchKey(E e){
        Node cur = dummyHead;
        while(cur != null && !cur.e.equals(e)){
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 查找链表中某一索引位置的结点
     * @param index 索引位置
     * @return
     */
    public Node searchIndex(int index){
        Node cur = dummyHead;
        int i = 0;
        while (i < index){
            cur = cur.next;
            i++;
        }
        return cur;
    }

    /**
     * 删除某位置的结点
     * @param index 要删除的位置
     * @return 对应该位置的结点
     */
    public Node removeIndex(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index Illegal");
        }
        Node cur = dummyHead;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        //获取要删除的结点
        Node delNode = cur.next;
        //当前结点的下一结点设置为要删除结点的下一结点
        cur.next = delNode.next;
        //要删除结点的下一结点的前一结点指向当前结点
        delNode.next.prev = cur;
        size --;
        delNode.next = null;
        delNode.prev = null;
        return delNode;
    }

    /**
     * 删除链表中关键字e中第一次出现的结点
     * @param e
     */
    public void removeKey(E e){

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\r\n");
        for(Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur).append("--");
        }
        res.append("N");
        return res.toString();
    }

}
