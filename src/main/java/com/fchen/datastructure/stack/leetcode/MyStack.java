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
    Queue<Integer> queueA;
    Queue<Integer> queueB;
    /** Initialize your data structure here. */
    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queueA.isEmpty()){
            queueA.add(x);
            return;
        }
        queueB.add(x);
        queueB.add(queueA.remove());

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!queueA.isEmpty()){
            return queueA.remove();
        }else{
            return queueB.remove();
        }

    }

    /** Get the top element. */
    public int top() {
        return queueA.isEmpty() ? queueB.peek() : queueA.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() ? queueB.isEmpty() : queueA.isEmpty();
    }
}
