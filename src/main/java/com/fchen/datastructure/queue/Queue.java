package com.fchen.datastructure.queue;

public interface Queue<E> {
    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 队列大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取队首的元素
     * @return
     */
    E getFront();

}
