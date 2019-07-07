package com.fchen.sort;

/**
 * @Classname InsertSort
 * @Description 插入排序
 * @Date 2019/7/7 21:31
 * @Author by Chen
 */
public class InsertSort {

    public int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            //定义待插入的树
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex > 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex +1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }
}
