package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-11-18 23:51
 * @desc: Leet code 第26题
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if(nums[j] != nums[i]){
                nums[++ i] = nums[j];
            }
        }
        return i + 1;
    }
}
