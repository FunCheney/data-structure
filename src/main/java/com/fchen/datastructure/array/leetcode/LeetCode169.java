package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-12-05 23:35
 * @desc: leetCode 第169
 * <p>
 *     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *     输入: [3,2,3]
 *     输出: 3
 * 示例 2:
 *     输入: [2,2,1,1,1,2,2]
 *     输出: 2
 * </p>
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
