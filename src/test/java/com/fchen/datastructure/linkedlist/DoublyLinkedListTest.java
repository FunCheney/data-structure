package com.fchen.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname DoublyLinkedListTest
 * @Description 双向链表API测试
 * @Date 2019/4/29 23:20
 * @Author by Chen
 */
@Slf4j
public class DoublyLinkedListTest {
    @Test
   public void testDoublyList(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 0; i < 5; i++){
            list.addLast(i);
            log.info(list.toString());
        }
        log.info(list.toString());
        list.addFirst(99);
        log.info(list.toString());
        list.addFirst(77);
        log.info(list.toString());
        list.removeIndex(0);
        log.info(list.toString());
        list.removeIndex(2);
        log.info(list.toString());
        list.removeKey(99);
        log.info(list.toString());
    }
}
