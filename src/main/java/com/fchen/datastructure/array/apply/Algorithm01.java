package com.fchen.datastructure.array.apply;

/**
 * @author: Fchen
 * @date: 2019-11-27 08:26
 * @desc: 已知数组A[0...N-1]，给定某数值Sum，找出数组中的若干个数，使得这些数的和为Sum
 *        暴力求解（枚举）
 */
public class Algorithm01 {
    int[] num = {1,2,3,4,5};
    int size = num.length;
    int sum = 10;
    public void getSum(int[] nums,int sum) {

    }

    public void EnumNumber(boolean[] flag, int i, int has){
        if(i >= size){
            return;
        }
        if(has + num[i] == sum){
            flag[i] = true;
            print(i);
        }
    }

    private void print(int i){
        System.out.print("[ ");
        for (int j = 0; j <= i;j++)
            System.out.print(num[i] + " ");

        System.out.println(" ]");
    }
}
