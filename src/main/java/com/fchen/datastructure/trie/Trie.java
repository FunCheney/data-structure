package com.fchen.datastructure.trie;

import java.util.TreeMap;

/**
 * @Classname Trie
 * @Description 字典树
 * @Date 2019/5/9 8:30
 * @Author by Chen
 */
public class Trie {
    private class Node{

        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加一个新的单词
     * @param str
     */
    public void add(String str){
        Node cur = root;
        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
}
