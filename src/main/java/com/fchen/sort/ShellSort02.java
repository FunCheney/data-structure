package com.fchen.sort;

import java.util.Arrays;

/**
 * @author: Fchen
 * @date: 2019-11-28 22:46
 * @desc: 希尔排序
 */
public class ShellSort02 {
    public static int[] sort(int[] arr){
        int n = arr.length;
        int h = 1;
        while (h < n / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            //将数组变为h有序
            for (int i = h; i < n; i++){
                for (int j = i; j >= h; j -= h){
                    if(arr[j] < arr[j -h]){
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
            h = h / 3;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,1,9,3,8};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
