package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-11-19 07:59
 * @desc: leetcode 第80题
 */
public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        //[0,0,1,1,1,1,2,3,3]
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int k = 0;
        for(int j = 1; j < nums.length; j++){
            int count = 0;
            while (nums[i] == nums[j]){
                count++;
                if(count < 2) {
                    i = j;
                }else{
                    i++;
                }
            }
            nums[++ i] = nums[j];
         }
        return ++i;
    }
}
