package com.fchen.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname CircularLinkedListTest
 * @Description 双向循环链表测试类
 * @Date 2019/6/4 19:46
 * @Author by Fchen
 */
@Slf4j
public class CircularLinkedListTest {
    @Test
    public void testCircularDoublyList(){
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        log.info(list.toString());
        list.addKey(1);
        log.info(list.toString());
        list.addKey(2);
        log.info(list.toString());
    }

    @Test
    public void testSingleCircularList(){
        SingleCircularLinkedList<Integer> list = new SingleCircularLinkedList<>();
        log.info(list.toString());
        list.add(1);
        log.info(list.toString());
        list.add(2);
        log.info(list.toString());
        list.addIndex(2,3);
        log.info(list.toString());
    }
}
