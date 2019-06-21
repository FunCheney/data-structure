package com.fchen.datastructure.stack.apply;

import java.util.Stack;

/**
 * @Classname ReversePolishNotationCal
 * @Description 逆波兰序表达式结算器
 * @Date 2019/6/21 20:14
 * @Author by Fchen
 */
public class ReversePolishNotationCal {

    Stack<Integer> stack = new Stack<>();

    public int cal(String exp){
        for (int i = 0; i < exp.length() ; i++) {
            if(!isOpr(exp.charAt(i))){
                stack.push(Integer.parseInt(exp.charAt(i) + ""));
            }else{
                int ch1 = stack.pop();
                int ch2 = stack.pop();
                int temp = 0;
                switch (exp.charAt(i)){
                    case '+':
                        temp = ch1 + ch2;
                        break;
                    case '-':
                        temp = ch2 - ch1;
                        break;
                    case '*':
                        temp = ch1 * ch2;
                        break;
                    case '/':
                        temp = ch2 / ch1;
                        break;
                    default:
                        break;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    private boolean isOpr(char val){
        return val == '+' || val== '-' || val == '*' || val == '/';
    }
}
