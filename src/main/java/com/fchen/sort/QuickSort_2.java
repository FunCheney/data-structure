package com.fchen.sort;

import java.util.Arrays;

/**
 * @Classname QuickSort_2
 * @Description 快速排序
 * @Date 2019/10/31 23:09
 * @Author by Chen
 */
public class QuickSort_2 {
    public static void main(String[] args) {
        int[] arr = {8,4,6,5,7,3,2,1};
        quickSort(arr,0,arr.length - 1);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    public static void  quickSort(int[] arr, int left, int right){
        if(right > left) {
            int j = partition(arr, left, right);
            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right){
        int i = left, j = right + 1;
        int num = arr[left];
        while (true){
            while (i < arr.length - 1 && arr[++i] <= num){
                if(left == right){
                    break;
                }
            }
            while (j > 0 && arr[--j] > num){
                if (j == left){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 将V = a[j]放入到正确的位置
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;
        // arr[lo...j-1] <= arr[j] <= arr[j+1...hi]
        return j;
    }
}
