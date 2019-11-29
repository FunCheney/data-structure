package com.fchen.datastructure.array.apply;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * @author: Fchen
 * @date: 2019-11-28 22:43
 * @desc: 已知数组A[0...N-1]，给定某数值Sum，找出数组中的若干个数，使得这些数的和为Sum
 *        分支限定
 */
public class Algorithm02 {
    static int[] num = {1,2,3,4,5,6,7,8,9,10};
    static int size = num.length;
    static int sum = 40;

    public static void main(String[] args) {
        boolean[] flag = new boolean[size];
        int residue = sum(num,size);
        findNumber(flag,0,0,residue);
    }

    private static void findNumber(boolean[] flag, int i,int has,int residue){
        if(i >= size){
            return;
        }
        if(has + num[i] == sum){
            flag[i] = true;
            print(flag);
            flag[i] = false;
        }else if((has + residue >= sum) && (has + num[i] <= sum)){
            flag[i] = true;
            findNumber(flag, i + 1, has + num[i], residue - num[i]);
        }
        if(has + residue - num[i] >= sum){
            flag[i] =false;
            findNumber(flag, i + 1, has, residue - num[i]);

        }
    }

    private static int sum(int[] num,int size){
        int residue = 0;
        for (int a: num) {
            residue = residue + a;
        }
        return residue;
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
