package com.fchen.sort;

/**
 * @Classname ShellSort
 * @Description 希尔排序
 * @Date 2019/7/8 22:57
 * @Author by Chen
 */
public class ShellSort {

    public int[] sort(int[] arr){
        int temp = 0;
        for(int step = arr.length / 2; step > 0; step = arr.length / 2){
            for (int i = step; i < arr.length; i++){
                for (int j = i - step; j >= 0; j -= step){
                    if(arr[j] > arr[j + step]){
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }
        return arr;
    }
}
