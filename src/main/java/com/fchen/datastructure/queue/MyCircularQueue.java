package com.fchen.datastructure.queue;

/**
 * @author: Fchen
 * @date: 2021/3/20 11:09 上午
 * @desc: 循环队列 622. 设计循环队列
 */
public class MyCircularQueue {

    private int[] data;

    /**
     * 指向队首所在的索引
     */
    private int front;

    /**
     * 队列下一个元素所在位置
     */
    private int tail;

    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        tail = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if(size == data.length) return false;
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        front = (front + 1) % data.length;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return data[(tail - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}