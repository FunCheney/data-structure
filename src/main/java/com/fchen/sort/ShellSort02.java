package com.fchen.sort;

/**
 * @author: Fchen
 * @date: 2019-11-28 22:46
 * @desc: 希尔排序
 */
public class ShellSort02 {
    public int[] sort(int[] arr){
        int n = arr.length;
        int h = 1;
        while (h < n / 3){
            h = 3 * h + 1;
        }
        while (h > 1){

        }
        return arr;
    }
}
