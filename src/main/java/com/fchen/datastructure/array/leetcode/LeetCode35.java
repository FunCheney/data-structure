package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-11-19 23:13
 * @desc: leetCode 35
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
                index = low;
            } else if (nums[mid] > target) {
                high = mid - 1;
                index = mid;
            } else
                return mid;
        }
        return index;
    }
}
