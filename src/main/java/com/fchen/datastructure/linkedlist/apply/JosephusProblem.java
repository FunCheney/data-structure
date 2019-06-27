package com.fchen.datastructure.linkedlist.apply;

import com.fchen.datastructure.linkedlist.SingleCircularLinkedList;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname JosephusProblem
 * @Description 约瑟夫问题
 *             N个人围成一圈，从第一个开始报数，第M个将被杀掉，
 *             最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3，1。
 * @Date 2019/6/18 22:24
 * @Author by Chen
 */
@Slf4j
public class JosephusProblem {
    public static void main(String[] args) {
        SingleCircularLinkedList<Integer> list = new SingleCircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.addIndex(2,3);
        list.add(4);
        list.add(5);
        System.out.println("循环链表为："+list);
        int i = list.josephusProblem(list, 1, 2);
        System.out.println("最后剩余结点的关键字："+i);

    }
}
