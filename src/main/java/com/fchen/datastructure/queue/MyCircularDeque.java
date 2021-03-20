package com.fchen.datastructure.queue;

/**
 * @author: Fchen
 * @date: 2021/3/20 11:47 上午
 * @desc: 循环双端队列 LeetCode 641. 设计循环双端队列
 */
public class MyCircularDeque {
    int head;
    int tail;
    int[] data;
    int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        data[] = value;
        tail = (head + 1) % data.length;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

    }

    /** Get the front item from the deque. */
    public int getFront() {

    }

    /** Get the last item from the deque. */
    public int getRear() {

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {

    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {

    }
}
