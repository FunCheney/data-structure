package com.fchen.datastructure.stack;

/**
 * @Classname Stack
 * @Description 栈的实现接口类
 * @Date 2019/4/27 16:48
 * @Author by FChen
 */
public interface Stack<E> {
    /**
     *获取栈的大小
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 压栈操作
     * @param e
     */
    void push(E e);

    /**
     * 弹栈操作
     * @return
     */
    E pop();

    /**
     * 获取栈顶的元素
     * @return
     */
    E peek();

}
