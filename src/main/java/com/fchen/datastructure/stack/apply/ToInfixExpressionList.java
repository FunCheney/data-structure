package com.fchen.datastructure.stack.apply;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname ToInfixExpressionList
 * @Description 中缀表达式转后缀表达式
 * @Date 2019/6/24 12:50
 * @Author by Fchen
 */
@Slf4j
public class ToInfixExpressionList {
    public String ToInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        //用于遍历中缀表达式字符串
        int i = 0;
        //多位数拼接
        String str;
        //没遍历一个字符  就放入c
        char c;
        do{
            c = s.charAt(i);
            if(c < 48 || c > 57){
                ls.add("" + c);
                i++;
            }else{
                //数字，考虑多位数
                str = "";
                while (i < s.length() && (s.charAt(i) >= 48 && s.charAt(i) <= 57)){
                    str += s.charAt(i);
                    i++;
                }
                ls.add("" + c);
            }
        }while ( i < s.length());
        List<String> strings = parseSuffixExpreList(ls);
        StringBuilder res = new StringBuilder();
        for (String o: strings) {
            res.append(o);
        }
        return res.toString();
    }

    private List<String> parseSuffixExpreList(List<String> ls){
        //定义两个栈
        //操作符栈
        Stack<String> s1 = new Stack<>();
        //说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后续还需逆序输出
        //这里使用List<String> 代替 Stack<String>
        List<String> s2 = new ArrayList<>();
        for (String str: ls) {
            //如果是一个数，加入S2
            if(str.matches("\\d+")){
                s2.add(str);
            }else if(str.equals("(")){
                s1.push(str);
            }else if(str.equals(")")){
                //如果是）,则依次弹出s1栈顶的元素，并压入s2，知道遇到左括号为止
                while (s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //将“(”弹出s1栈
                s1.pop();
            }else{
                //当str的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并压入s2中
                while (s1.size() != 0 && priority(s1.peek()) >= priority(str)){
                    s2.add(s1.pop());
                }
                //将当前的操作符压入栈中
                s1.push(str);
            }
        }
        //将s1中剩余的运算符加入s2中
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    private int priority(String opr){
        switch (opr){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
                default:
                    return -1;
        }
    }
}
