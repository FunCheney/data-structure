package com.fchen.datastructure.stack;

import com.fchen.datastructure.stack.apply.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

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

    @Test
    public void compareStack(){
        int opt = 100000;
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        double linkedStackTime = testStack(stack, opt);
        log.info("LinkedStackTime is:{}",linkedStackTime);
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double v = testStack(arrayStack, opt);
        log.info("ArrayStackTime is:{}",v);
    }

    @Test
    public void calculatorTest(){
        Calculator calculator = new Calculator();
        String exp = "300+8*5/2+200/10";
        int cal = calculator.cal(exp.trim());
        log.info("中序表达式:{} = {}",exp,cal);
    }


    private double testStack(Stack<Integer> stack, int opt){
        Long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < opt; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opt;i++){
            stack.pop();
        }
        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
