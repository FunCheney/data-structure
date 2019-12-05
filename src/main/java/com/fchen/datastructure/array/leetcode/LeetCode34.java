package com.fchen.datastructure.array.leetcode;

/**
 * @author: Fchen
 * @date: 2019-12-04 23:06
 * @desc: leetcode 34 题题解
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int firstIndex = findFirst(nums, target);
        int lastIndex = findLast(nums, target);
        arr[0] = firstIndex;
        arr[1] = lastIndex;
        return arr;
    }
    private int findFirst(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else {
                if(mid != 0 && nums[mid - 1] == target){
                    hi = mid - 1;
                }else {
                    return mid;
                }
            }

        }
        return -1;
    }
    private int findLast(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else {
                if(mid < nums.length - 1 && nums[mid + 1] == target){
                    lo = mid + 1;
                }else {
                    return mid;
                }
            }

        }
        return -1;
    }
}
