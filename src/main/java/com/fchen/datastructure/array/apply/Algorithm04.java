package com.fchen.datastructure.array.apply;

import com.sun.tools.javac.util.List;

import java.util.Arrays;

/**
 * @author: Fchen
 * @date: 2019-11-29 23:21
 * @desc: 给定数组A[0...N-1]，元素只能取0，1，2三个值，
 *        设计算法，使得数组排列成”000..0011...11122..222“的形式。
 */
public class Algorithm04 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,2,2,0,1,1,2,0,2,2,2,0,2,0};
        int[] newArr = algorithm(arr);
        System.out.println(List.of(Arrays.toString(newArr)));

    }
    public static int[] algorithm(int[] arr){
        int begin = 0;
        int cur = 0;
        int end = arr.length - 1;
        while (cur <= end){
            if(arr[cur] == 2){
                swap(arr,cur,end);
                end--;
            }else if (arr[cur] == 1){
                cur++;
            }else {
                if(begin == cur){
                    begin++;
                    cur++;
                }else {
                    swap(arr,begin,cur);
                    begin++;
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr,int cur, int end){
        int temp = arr[cur];
        arr[cur] = arr[end];
        arr[end] = temp;

    }
}
