package com.fchen.datastructure.linkedlist.leetcode;

import java.util.ArrayList;

/**
 * @Classname PalindromeLinkedList
 * @Description Palindrome Linked List
 *              LeetCode - 234
 *                Given a singly linked list, determine if it is a palindrome.
 * @Date 2019/6/10 13:44
 * @Author by Fchen
 */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int mid = list.size() / 2;
        if(mid > 0){
            for (int i = 0; i <= mid; i++) {
                if(list.get(i).intValue() != list.get(list.size() -1 - i).intValue()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode lat = head.next;
        ListNode pre = head;
        while (lat != null && lat.next != null){
            lat = lat.next.next;
            pre = pre.next;
        }
        //上述循环结束后，pre结点为该链表的的中间结点处
        //cur为链表后半部分结点的开始结点
        ListNode cur = pre.next;
        pre.next = null;
        //用来构造原链表的后半部分结点
        ListNode p = null;
        while (cur != null){
            //用来控制后半部分链表的循环
            ListNode q = cur.next;
            //让当前结点的下一结点 为结点p 第一次是null; 下一次 则为上一次插入的结点
            cur.next = p;
            //将当前的结点赋值给
            p = cur;
            //控制链表循环
            cur = q;
        }
        while (p != null && head != null){
            if(p.val != head.val){
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }
}
