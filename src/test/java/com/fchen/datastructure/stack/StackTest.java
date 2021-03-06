package com.fchen.datastructure.stack;

import com.fchen.datastructure.stack.apply.Calculator;
import com.fchen.datastructure.stack.apply.ReversePolishNotationCal;
import com.fchen.datastructure.stack.apply.ToInfixExpressionList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
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

    @Test
    public void calculatorTest(){
        Calculator calculator = new Calculator();
        String exp = "300+8*5/2+200/10";
        int cal = calculator.cal(exp.trim());
        log.info("中序表达式:{} = {}",exp,cal);
    }

    @Test
    public void reversePolishNotationCalTest(){
        ReversePolishNotationCal calculator = new ReversePolishNotationCal();
//        30*20+250/50*123
//          30 20 * 250 50 / 123 +
        String exp = "34+5*6-";
        int cal = calculator.cal(exp.trim());
        log.info("逆波兰序表达式:{} = {}",exp,cal);
    }
    @Test
    public void toInfixExpressionListTest(){
        ToInfixExpressionList list = new ToInfixExpressionList();
        String exp = "3+4*5/6";
        List<String> strings = list.ToInfixExpressionList(exp);
        StringBuilder sb = new StringBuilder();
        for (String s: strings) {
            sb.append(s);
            if(sb.length() > 0){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
