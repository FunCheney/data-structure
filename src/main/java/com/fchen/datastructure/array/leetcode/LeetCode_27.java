package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-11-18 08:05
 * @desc: leetCode 第27题题解
 */
public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        boolean flag = false;
        for(int i = 0; i < nums.length - 1;i++){
            if(nums[i] == val){
                flag = true;
                continue;
            }
            count++;
        }
        return flag ? count ++ : count;
    }
}
