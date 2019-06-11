package com.fchen.datastructure.stack.leetcode;

import com.fchen.datastructure.array.Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname MyStack
 * @Description 使用队列实现栈
 * @Date 2019/6/11 16:42
 * @Author by Fchen
 */
public class MyStack {
    Queue<Integer> queue;
    Queue<Integer> queue1;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        queue1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

       return 0;
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
