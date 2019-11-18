package com.fchen.datastructure.array.apply;

import com.fchen.datastructure.array.Array;

/**
 * @author: Fchen
 * @date: 2019-11-16 11:17
 * @desc: 基于数组的二分查找
 */
public class BinarySearchBaseArray {

    /**
     *
     * @param array
     * @param e
     * @return
     */
    public int binarySearch(Array<Integer> array, Integer e){
        int low = 0;
        int high = array.getSize() - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(e.compareTo(array.getIndex(mid)) < 0 ){
                high = mid - 1;
            }else if(e.compareTo(array.getIndex(mid)) > 0){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
