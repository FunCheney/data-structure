package com.fchen.datastructure.linkedlist.leetcode;

/**
 * @Classname ReverseLinkedList
 * @Description ReverseLinkedList
 *              LeetCode-206
 *                Reverse a singly linked list.
 * @Date 2019/6/10 23:21
 * @Author by Fchen
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {

        ListNode p = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = p;
            p = head;
            head = nextNode;
        }
        return p;

    }
}
