package com.fchen.sort;

import java.util.Arrays;

/**
 * @Classname MergeSort
 * @Description 归并排序
 * @Date 2019/10/31 18:48
 * @Author by Chen
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,6,5,7,3,2,1};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right,int[] temp){

        if(left < right){
            int mid = (left + right) / 2; //中间索引
            mergeSort(arr, left, mid, temp); // 左递归分解
            mergeSort(arr, mid + 1, right, temp); // 右递归分解
            merge(arr,left,mid,right,temp);// 分解一次合并一次
        }
    }
    public static void merge(int[] arr, int left, int mid, int right,int[] temp){
        int i = left; //左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int t = 0; // 指向临时数组的当前索引
        // 将左右两边的数据按照规则赋值到临时数组中,直到左右两边的有序队列有一边复制完毕
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 判断左边的数据是否复制完毕，没有，则加入临时数组中
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        // 将temp数组的元素复制到原来的数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
