package com.fchen.datastructure.array.apply;

/**
 * @author: Fchen
 * @date: 2019-11-29 23:25
 * @desc: 已知数组A[0...N-1]，给定某数值Sum，找出数组中的若干个数，使得这些数的和为Sum
 *        对负数进行分支限定
 */
public class Algorithm03 {
    static int[] num = {-3,-2,-5,4,2,1,3};
    static int size = num.length;
    static int sum = 5;

    public static void main(String[] args) {
        boolean[] flag = new boolean[size];
        int negative = negative(num);
        int positive = positive(num);
        findNumber(flag,0,0,negative,positive);
    }

    private static void findNumber(boolean[] flag, int i,int has,int negative,int positive){
        if(i >= size){
            return;
        }
        if(has + num[i] == sum){
            flag[i] = true;
            print(flag);
        }
        if(num[i] > 0){
            if((has + positive >= sum) && (has + num[i] <= sum)){
               flag[i] = true;
               findNumber(flag, i + 1, has + num[i],negative,positive - num[i]);
               flag[i] = false;
            }
            if(has + positive - num[i] >= sum){
                flag[i] = false;
                findNumber(flag,i + 1, has, negative, positive - num[i]);
            }
        }else{
            if(has + num[i] + positive >= sum){
                flag[i] = true;
                findNumber(flag,i + 1, has + num[i],negative - num[i], positive);
                flag[i] = false;
            }
            if((has + negative <= sum) && (has + positive >= sum)){
                flag[i] = false;
                findNumber(flag, i + 1, has, negative - num[i],positive);
            }
        }
    }

    /**
     * 计算数组中所有负数的和
     * @param num
     * @return
     */
    private static int negative(int[] num){
        int negative = 0;
        for (int a: num) {
            if(a < 0){
                negative += a;
            }
        }
        return negative;
    }

    /**
     * 计算数组中所有正数的和
     * @param num
     * @return
     */
    private static int positive(int[] num){
        int positive = 0;
        for (int a: num) {
            if(a > 0){
                positive += a;
            }
        }
        return positive;
    }

    private static void print(boolean[] flag) {
        System.out.print("[ ");
        for (int j = 0; j < flag.length; j++){
            if (flag[j]) {
                System.out.print(num[j] + " ");
            }
        }
        System.out.println("]");
    }
}
