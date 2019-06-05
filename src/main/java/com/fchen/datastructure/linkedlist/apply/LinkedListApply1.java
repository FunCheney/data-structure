package com.fchen.datastructure.linkedlist.apply;

import com.fchen.datastructure.linkedlist.LinkedList;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname LinkedListApply1
 * @Description 单链表的反转
 * @Date 2019/6/5 20:32
 * @Author by Fchen
 */
@Slf4j
public class LinkedListApply1 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            linkedList.addFirst(i);
        }
        log.info(linkedList.toString());
        LinkedList reverse = linkedList.reverse(linkedList);
        log.info(reverse.toString());
    }

}
