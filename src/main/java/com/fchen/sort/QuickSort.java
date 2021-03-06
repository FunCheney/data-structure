package com.fchen.sort;

import java.util.Arrays;

/**
 * @Classname QuickSort
 * @Description 快速排序
 * @Date 2019/10/30 21:11
 * @Author by Chen
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8,4,6,5,7,3,2,1};
        quickSort(arr,0,arr.length - 1);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left, int right){
        int l = left;
        int r = right;
        int mid = (left + right) / 2;
        int temp = 0;
        // while循环是让比mid 小的数放到左边，比mid大的数放在右边
        while (l < r){
            while (arr[l] < arr[mid]){
                l++;
            }
            while (arr[r] > arr[mid]){
                r--;
            }
            // l >= r 说明mid左右两边的值，已经按照左边小于mid值，右边大于等于mid值
            if(l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换后 arr[l] == arr[mid]相等 r--
            if(arr[l] == arr[mid]){
                r--;
            }
            if(arr[r] == arr[mid]){
                l++;
            }
        }
        // 如果 l==r,必须l++,r--,否则出现栈溢出
        if(l == r){
            l++;
            r--;
        }
        if(left < r){
            quickSort(arr,left,r);
        }
        if(right > l){
            quickSort(arr,l,right);
        }
    }
}
