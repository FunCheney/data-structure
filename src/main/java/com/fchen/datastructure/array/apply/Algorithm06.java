package com.fchen.datastructure.array.apply;

import java.util.Arrays;

/**
 * @author: Fchen
 * @date: 2019-11-30 09:29
 * @desc: 完美洗牌算法：长度为2n的数组{a1,a2,a3...an,b1,b2,b3...bn}，
 *   经过整理后变成{a1,b1,a2,b2...,an,bn}，要求时间复杂度O(n)，空间复杂度为O(1)。
 */
public class Algorithm06 {
    static int[] arr = {1,1,1,1,2,2,2,2};

    public static void main(String[] args) {
        int[] prefect = prefect(arr, arr.length / 2);
        System.out.println(Arrays.toString(prefect));
    }

    public static int[] prefect(int[] arr, int n){

        int n2, m, i, k, t;
        int start = 0;
        for (; n > 1;){
            //step 1
            n2 = n * 2;
            for (k = 0, m = 1; n2 / m >= 3; ++k, m *= 3)
                ;
            m /= 2;

            //step 2
            rightRotate(start + m, m, n);

            //step 3
            for(i = 0, t = 1; i < k; ++i, t *= 3){
                cycleLeader(arr, t, m * 2 + 1);
            }
            //step 4
            start += m * 2;
            n -= m;


        }
        // n = 1
        t = arr[1];
        arr[1] = arr[2];
        arr[2] = t;
        return arr;
    }

    /**
     * 等到完美洗牌的环
     * @param arr
     * @param from 表示环的头部
     * @param mod 表示要取摸的值
     */
    private static void cycleLeader(int[] arr, int from, int mod){
        int t,i;
        for (i = from * 2 % mod; i != from; i = i * 2 % mod){
            t = arr[i];
            arr[i] = arr[from];
            arr[from] = t;
        }
    }

    /**
     * 循环右移num位
     * @param start
     * @param num
     * @param n
     */
    private static void rightRotate(int start, int num, int n){
        reverse(start, 0 ,n - num - 1);
        reverse(start, n - num, n - 1);
        reverse(start, 0, n - 1);
    }

    private static void reverse(int start, int from, int to){
        int t;
        for (; from < to; ++from, --to){
            t = arr[from + start];
            arr[from + start] = arr[to + start];
            arr[to + start] = t;
        }
    }
}
