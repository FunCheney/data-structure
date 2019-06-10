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
        ListNode cur = pre.next;
        pre.next = null;
        ListNode p = null;
        while (cur != null){
            ListNode q = cur.next;
            cur.next = p;
            p = cur;
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
