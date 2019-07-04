package com.fchen.sort;

/**
 * @Classname BubbleSort
 * @Description 冒泡排序
 * @Date 2019/7/3 21:56
 * @Author by Chen
 */
public class BubbleSort {

    public int[] sort(int[] arr){
        //用来交换数据
        int temp = 0;
        boolean flag = false;
        for(int j = 0; j < arr.length - 1; j++){
            for(int i = 0; i < arr.length - 1 - j; i++){
                if(arr[i] > arr[i + 1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        return arr;
    }
}
