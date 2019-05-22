package com.fchen.datastructure.array;


import java.util.ArrayList;

/**
 * @Classname Array
 * @Description 使用java中的数组模拟创建动态数组
 * @Date 2019/4/26 13:35
 * @Author by FChen
 */
public class Array<E> {
    /**
     * 存储数组中元素
     */
    private E[] data;

    /**
     * 数组中存储元素的个数
     */
    private int size;

    /**
     * 有参构造函数
     * @param capacity 数组容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 传入数组方式构建动态数组
     * @param arr
     */
    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 无参构造函数 默认数组容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的大小
     * @return 数组大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return 静态数组的data的length
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *  向所有元素后面添加一个元素
     * @param e 要插入的元素
     */
    public void addLast(E e){
       addIndex(e,size);
    }

    /**
     * 在第一个位置插入一个元素
     * @param e
     */
    public void addFirst(E e){
        addIndex(e,0);
    }

    /**
     * 在某一索引插入某一元素
     * @param e     插入的元素
     * @param index 插入元素的位置
     */
    public void addIndex(E e,int index){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("index out of bound");
        }
        if(size == data.length){
            resize(data.length + (data.length >> 1));
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] =data[i];
        }
        data = newData;
    }

    /**
     * 获取数组某一索引元素
     * @param index 索引
     * @return  该索引对应的元素
     */
    public E getIndex(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    /**
     * 获取数组中最后一个元素
     * @return
     */
    public E getLast(){
        return getIndex(size - 1);
    }

    /**
     * 获取数组中第一个元素
     * @return
     */
    public E getFirst(){
        return getIndex(0);
    }

    /**
     * 修改某一索引的元素
     * @param e    元素
     * @param index 索引
     */
    public void set(E e,int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = e;
    }

    /**
     * 数组中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 数组中元素e所在的位置
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i++){
           if(data[i].equals(e)){
               return i;
           }
        }
        return -1;
    }

    /**
     * 删除索引位置的元素
     * @param index
     * @return 返回删除的元素
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("index out of bound");
        }
        E res = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] =data[i+1];
        }
        data[size] = null;
        size --;
        if(size == data.length / 4){
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 删除数组中的第一元素
     * @return
     */
    public E removeFirst(){
       return remove(0);
    }

    /**
     * 删除数组中的某个元素
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if( index != -1){
            remove(index);
        }
    }

    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("index illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    /**
     * 删除数组中的最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size: %d ,and capacity: %d\n",size,getCapacity()));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i < size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
