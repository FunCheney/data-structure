package com.fchen.datastructure.queue;

/**
 * @Classname LoopQueue
 * @Description 循环队列
 * @Date 2019/4/27 18:24
 * @Author by Chen
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;

    /**
     * 指向队首所在的索引
     */
    private int front;

    /**
     * 队列下一个元素所在位置
     */
    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        //判断队列是否满
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(front == tail){
            throw  new ArrayIndexOutOfBoundsException();
        }
        E ret = data[front];
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size; i++){
            newData[i] = data[ (i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("queue size: %d ,and capacity: %d\n",size,getCapacity()));
        res.append("front [");
        for(int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
