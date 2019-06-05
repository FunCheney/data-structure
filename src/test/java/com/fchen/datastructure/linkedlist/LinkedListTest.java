package com.fchen.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname LinkedListTest
 * @Description 单链表实现API测试类
 * @Date 2019/4/29 23:20
 * @Author by Chen
 */
@Slf4j
public class LinkedListTest {
    @Test
    public void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            log.info(linkedList.toString());
        }
        linkedList.removeKey(4);
        log.info(linkedList.toString());
        linkedList.removeKey(0);
        log.info(linkedList.toString());
        linkedList.removeKey(2);
        log.info(linkedList.toString());
        linkedList.add(2,666);
        log.info(linkedList.toString());
        linkedList.remove(2);
        log.info(linkedList.toString());
        linkedList.removeFirst();
        log.info(linkedList.toString());
        linkedList.removeLast();
        log.info(linkedList.toString());
        Integer indexFromLast = linkedList.getIndexFromLast(2);
        log.info("{}",indexFromLast);
    }
}
