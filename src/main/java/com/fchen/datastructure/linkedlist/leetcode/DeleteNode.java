package com.fchen.datastructure.linkedlist.leetcode;

/**
 * @Classname DeleteNode
 * @Description 删除链表中的结点
 * @Date 2019/6/18 12:01
 * @Author by Fchen
 */
public class DeleteNode {
    /**
     * Definition for singly-linked list.
     */
      public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
