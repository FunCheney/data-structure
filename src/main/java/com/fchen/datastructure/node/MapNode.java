package com.fchen.datastructure.node;

/**
 * @Classname Node
 * @Description 节点结构类型
 * @Date 2019/5/2 16:40
 * @Author by Chen
 */
public class MapNode<K,V> {

    public K key;

    public V value;
    /**
     * 下一节点
     */
    public MapNode next;

    public MapNode(K key, V value, MapNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public MapNode(K key){
       this(key, null, null);
    }
    public MapNode(){
        this(null,null,null);
    }

    @Override
    public String toString() {
        return key.toString() + ":" + value.toString();
    }
}
