package com.fchen.datastructure.set;

public interface Set<E> {
    /**
     * 集合中添加元素e 不能添加重复元素
     * @param e
     */
    void add(E e);

    /**
     * 删除集合中的元素e
     * @param e
     */
    void remove(E e);

    /**
     * 集合中是否包含元素额
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 集合的大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
