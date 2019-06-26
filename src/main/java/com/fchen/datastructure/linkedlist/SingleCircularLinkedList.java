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

    /**
     * 再循环链表中每个一定的步长删除一个节点
     * @param list  待操作的链表
     * @param start 从第几个结点开始
     * @param step  每隔几个数删除一个结点
     * @return 最后剩余的结点
     */
    public int josephusProblem(SingleCircularLinkedList list, int start, int step){
        if(start < 0 || start > size){
            throw new IllegalArgumentException("参数输入有误");
        }
        if(size == 1){
            return (Integer) sentinel.next.key;
        }
        //创建辅助结点,让辅助结点指向哨兵结点
        Node helper = sentinel;
        //指向链表的第一个结点。用来控制循环
        Node curNode = sentinel.next;
        for(int i = 0; i < start; i++){
            //删除结点之前，让当前结点移动到 开始循环的结点
            curNode = curNode.next;
            //让辅助结点 移动到 开始循环结点的前一结点
            helper = helper.next;
        }
        //删除距离当前结点 step - 1 位置的结点，直到链表中只有一个结点
        while (true){
            if(curNode.next.equals(helper)){
                break;
            }
            for(int j = 0; j < step - 1; j++){
                curNode = curNode.next;
                helper = helper.next;
            }
            System.out.println("要删除的结点的关键字为:"+ curNode.key);
            //将当前结点所在位置的结点删除
            curNode = curNode.next;
            //删除
            helper.next = curNode;

        }
        return (Integer) curNode.key;
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
            sb.append("-->").append(curNode.key);
            curNode = curNode.next;
        }
        sb.append(sentinel.key);
        return sb.toString();
    }

}
