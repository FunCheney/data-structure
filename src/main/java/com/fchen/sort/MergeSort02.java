package com.fchen.sort;

import java.util.Arrays;

/**
 * @author: Fchen
 * @date: 2019-12-07 15:44
 * @desc:
 */
public class MergeSort02 {
    public static void main(String[] args) {
        int[] arr = {8,4,6,5,7,3,2,1};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int lo, int hi, int[] temp){
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        //数组的左半边排序
        sort(arr, lo, mid, temp);
        //数组的右半边排序
        sort(arr, mid + 1, hi, temp);
        merge(arr, lo, mid, hi, temp);
    }
    public static void merge(int[] arr, int lo, int mid, int hi, int[] temp){
        int i = lo,j = mid + 1;
        for (int k = lo; k <= hi; k++){
            temp[k] = arr[k];
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid )
                // 左半边用尽，取右半边元素
                arr[k] = temp[j++];
            else if(j > hi)
                // 右半边用尽，取左半边元素
                arr[k] = temp[i++];
            else if(temp[j] > temp[i])
                // 右半边当前的元素大于左半边当前的元素，取左半边的元素
                arr[k] = temp[i++];
            else
                //右半边当前的元素小于等于左半边当前的元素,取右半边的元素
                arr[k] = temp[j++];
        }
    }
}
