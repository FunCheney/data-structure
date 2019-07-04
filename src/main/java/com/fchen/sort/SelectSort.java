package com.fchen.sort;

/**
 * @Classname SelectSort
 * @Description 选择排序
 * @Date 2019/7/4 22:30
 * @Author by Chen
 */
public class SelectSort {

    public int[] sort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            int minNum = arr[i];
            int temp = 0;
            for(int j = i + 1; j < arr.length - 1; j++){
                if(minNum > arr[j]){
                    minNum = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }
        }
        return arr;
    }
}
