package com.fchen.datastructure.array.apply;

/**
 * @author: Fchen
 * @date: 2019-11-30 09:29
 * @desc: 完美洗牌算法：长度为2n的数组{a1,a2,a3...an,b1,b2,b3...bn}，
 *   经过整理后变成{a1,b1,a2,b2...,an,bn}，要求时间复杂度O(n)，空间复杂度为O(1)。
 */
public class Algorithm06 {

    public int[] prefect(int[] arr, int n){
        int n2, m, i, k, t;
        for (; n > 1;){
            //step 1
            n2 = n * 2;
            for (k = 0, m = 1; n2 / m >= 3; ++k, m *= 3)
                ;
            m /= 2;

            //step 2
            rightRotate(arr, m, n);

            //step 3
            for(i = 0, t = 1; i < k; ++i, t *= 3){
                cycleLeader(arr, t, m * 2 + 1);
            }
            //step 4
            int[] newArr = new int[arr.length - 2 * m];
            for (int j = 2 * m; j < arr.length; j++){
              newArr[i] = arr[j - 1];
            }
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
    private void cycleLeader(int[] arr, int from, int mod){
        int t,i;
        for (i = from * 2 % mod; i != from; i = i * 2 % mod){
            t = arr[i];
            arr[i] = arr[from];
            arr[from] = t;
        }
    }

    /**
     * 循环右移num位
     * @param arr
     * @param num
     * @param n
     */
    private void rightRotate(int[] arr, int num, int n){
        reverse(arr, 1, n - num);
        reverse(arr, n - num + 1, n);
        reverse(arr, 1, n);
    }

    private void reverse(int[] arr, int from, int to){
        int t;
        for (; from < to; ++from, --to){
            t = arr[from];
            arr[from] = arr[to];
            arr[to] = t;
        }
    }
}
