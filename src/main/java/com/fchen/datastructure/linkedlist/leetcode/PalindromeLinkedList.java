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
        ListNode next = head.next;
        ListNode cur = head;
        while (next != null && next.next != null){
            next = next.next.next;
            cur = cur.next;
        }
        ListNode newHead = cur;
        newHead.next = null;
        ListNode p = null;
        while (cur != null){
            ListNode insertNode = cur;
            insertNode.next = p;
            cur = cur.next;
        }
        p = cur;
        while (p != null && head != null){
            if(p.val != head.val){
                return false;
            }
        }
        return true;
    }
}
