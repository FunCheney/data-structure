package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-12-05 23:35
 * @desc: TODO
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer target = null;
        for (int num: nums) {
            if(count == 0){
                target = num;
            }
            count += target == num ? 1 : -1;
        }
        return target;
    }
}
