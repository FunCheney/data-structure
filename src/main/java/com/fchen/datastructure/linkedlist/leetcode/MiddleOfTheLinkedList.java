package com.fchen.datastructure.linkedlist.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Classname MiddleOfTheLinkedList
 * @Description 链表的中间节点
 *              LeetCode-876:
 *                  Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *                  If there are two middle nodes, return the second middle node.
 * @Date 2019/6/10 11:48
 * @Author by Fchen
 */
public class MiddleOfTheLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode cur = head.next;
        while (cur != null){
            list.add(cur);
            cur = cur.next;

        }
        return list.get(list.size() / 2);
    }

    public boolean isPalindrome(ListNode head) {
        Stack list = new Stack<>();
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            list.push(cur.val);
            cur = cur.next;
            count++;
        }

        int mid = count / 2;
        if(mid > 0){
            for (int i = 0; i <= mid; i++) {
                if(list.get(i) != list.get(list.size() -1 - i)){
                    return false;
                }
            }
        }
        return true;

    }

}
