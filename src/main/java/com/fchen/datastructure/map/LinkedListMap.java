package com.fchen.datastructure.map;

import com.fchen.datastructure.node.MapNode;

/**
 * @Classname LinkedListMap
 * @Description 基于链表的映射类
 * @Date 2019/5/5 22:35
 * @Author by Chen
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    private MapNode dummyHead;

    private int size;

    public LinkedListMap() {
        dummyHead = new MapNode<>();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        MapNode node = getNode(key);
        if(node == null){
            dummyHead.next = new MapNode((K)key,(V)value,dummyHead.next);
            size++;
        }else{
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        MapNode prev = dummyHead;
        while (prev.next != null){
            if(prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null){
            MapNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return (V)delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) == null ? false : true;
    }

    @Override
    public V get(K key) {
        MapNode node = getNode(key);
        return node == null ? null : (V)node.value;
    }

    @Override
    public void set(K key, V value) {
        MapNode node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException("key is not exist");
        }else{
            node.value = value;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private MapNode getNode(K key){
        MapNode cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
