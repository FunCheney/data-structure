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
            //用来表示当前最小值所在的索引
            int minIndex = i;
            //最小的元素在外层循环的位置
            int minNum = arr[i];
            for(int j = i + 1; j < arr.length - 1; j++){
                //内存循环判断有没有比假定最小元素还要小的元素
                if(minNum > arr[j]){
                    //重新赋值最小元素
                    minNum = arr[j];
                    //重新赋值最小元素所在位置
                    minIndex = j;
                }
            }
            if(minIndex != i){
                //有比假定最小值还小的元素，交换位置
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }
        }
        return arr;
    }
}
