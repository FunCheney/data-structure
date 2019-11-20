package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-11-20 08:14
 * @desc: LeetCode 第66题
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            if(digits[i] % 10 != 0){
                return digits;
            }
            digits[i] = 0;
        }
        return digits;
    }
}
