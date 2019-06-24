package com.fchen.datastructure.stack.apply;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname ToInfixExpressionList
 * @Description 中缀表达式转后缀表达式
 * @Date 2019/6/24 12:50
 * @Author by Fchen
 */
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
            if((c = s.charAt(i)) < 48 || (s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else{
                //数字，考虑多位数
                str = "";
                while (i < s.length() && ((c = s.charAt(i)) >= 48 || (c = s.charAt(i)) <= 57)){
                    str += c;
                    i++;
                }
                ls.add("" + c);
            }
        }while ( i < s.length());

        return null;
    }

    public List<String> parseSuffixExpreList(List<String> ls){
        //定义两个栈
        //操作符栈
        Stack<String> s1 = new Stack<>();
        //说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后续还需逆序输出
        //这里使用List<String> 代替 Stack<String>
        List<String> s2 = new ArrayList<String>();
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
                // 当 s1
            }
        }
        return null;
    }
}
