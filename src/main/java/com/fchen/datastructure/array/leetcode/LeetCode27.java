package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-11-18 08:05
 * @desc: leetCode 第27题题解
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(val != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
