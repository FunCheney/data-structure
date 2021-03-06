package com.fchen.datastructure.stack.apply;

import com.fchen.datastructure.stack.ArrayStack;

/**
 * @Classname Calculator
 * @Description  计算器  中序表达式
 * @Date 2019/6/20 21:01
 * @Author by Fchen
 */
public class Calculator {

    ArrayStack num = new ArrayStack<Integer>();

    ArrayStack opr = new ArrayStack<Character>();

    public int cal(String exp){
        int result = 0;
        int index = 0;
        Integer num1;
        Integer num2;
        Character c;
        String strTemp = "";
        while (true){
            c = exp.substring(index, index + 1).charAt(0);
            //判断得到的当前字符是什么
            if(isOpr(c)){
                //是操作符
                if(!opr.isEmpty()){
                    //符号栈有操作符
                    if(priority(c) <= priority((Character)opr.peek())){
                        //当前符号的优先级 小于 等于 符号栈栈顶的优先级
                        Character op = (Character) opr.pop();
                        num1 = (Integer) num.pop();
                        num2 = (Integer) num.pop();
                        result = cal(num1, num2, op);
                        //运算结果入栈
                        num.push(result);
                        //当前的操作符入符号栈
                        opr.push(c);
                    }else{
                        opr.push(c);
                    }
                }else {
                    opr.push(c);
                }
            }else{
                strTemp += c;
                if((index + 1) < exp.length()){
                    while ((index + 2) <= exp.length() && !isOpr(exp.substring(index + 1, index + 2).charAt(0))){
                        strTemp += exp.substring(index + 1, index + 2);
                        index++;
                    }
                }
                num.push(Integer.parseInt(strTemp));
                strTemp = "";
            }
            // index + 1, 并判断当前字符串是否遍历完成
            index++;
            if(index >= exp.length()){
                break;
            }
        }
        while (true){
            if(opr.isEmpty()){
                break;
            }
            num1 = (Integer) num.pop();
            num2 = (Integer) num.pop();
            c = (Character) opr.pop();
            result = cal(num1, num2, c);
            num.push(result);
        }
        return result;
    }

    /**
     * 用来确定运算符的优先级
     * @return 返回数字越大优先级越高
     */
    private int priority(char opr){
        if(opr == '*' || opr == '/'){
            return 1;
        }else if(opr == '+' || opr == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断是否是一个运算符
     * @param val
     * @return
     */
    private boolean isOpr(char val){
        return val == '+' || val== '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param opr
     * @return
     */
    private int cal(int num1, int num2, int opr){
        int res = 0;
        switch (opr){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
                default:
                    break;
        }
        return res;
    }
}
