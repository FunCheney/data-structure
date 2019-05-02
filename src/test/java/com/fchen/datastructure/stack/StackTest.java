package com.fchen.datastructure.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname StackTest
 * @Description 栈测试类
 * @Date 2019/4/27 17:14
 * @Author by Chen
 */
@Slf4j
public class StackTest {
    @Test
    public void testArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0; i < 3; i++){
            stack.push(i);
            log.info(stack.toString());
        }
        stack.pop();
        log.info(stack.toString());
    }

    @Test
    public void testLinkedListStack(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for(int i = 0; i < 3; i++){
            stack.push(i);
            log.info(stack.toString());
        }
        stack.pop();
        log.info(stack.toString());
    }
}
