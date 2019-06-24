package com.fchen.datastructure.stack.apply;

import java.util.ArrayList;
import java.util.List;

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
            }
        }while ( i < s.length());
        return null;
    }
}
