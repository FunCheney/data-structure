package com.fchen.datastructure.array.apply;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Fchen
 * @date: 2019-11-27 08:26
 * @desc: 已知数组A[0...N-1]，给定某数值Sum，找出数组中的若干个数，使得这些数的和为Sum
 *        暴力求解（枚举）
 */
public class Algorithm01 {
    static int[] num = {1,2,3,4,5};
    static int size = num.length;
    static int sum = 10;

    public static void main(String[] args) {
        boolean[] flag = new boolean[size];
        enumNumber(flag,0,0);
    }



    public static void enumNumber(boolean[] flag, int i, int has){
        if(i >= size){
            return;
        }
        if(has + num[i] == sum){
            flag[i] = true;
            print(flag);
            flag[i] = false;
        }
        flag[i] = true;
        enumNumber(flag, i + 1, has + num[i]);
        flag[i] = false;
        enumNumber(flag, i + 1, has);
    }

    private static void print(boolean[] flag) {
        System.out.print("[ ");
        for (int j = 0; j < flag.length; j++){
            if (flag[j]) {
                System.out.print(num[j] + " ");
            }
        }
        System.out.println("]");
    }
}
