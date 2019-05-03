package com.fchen.datastructure.tree.bst;

import com.fchen.datastructure.tree.binarysearchtree.BST;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname BSTTest
 * @Description 二叉搜索树测试用例
 * @Date 2019/5/3 15:39
 * @Author by Chen
 */
@Slf4j
public class BSTTest {
    @Test
    public void testBstPreOrder(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        bst.preOrder();
       log.info(bst.toString());
    }

    @Test
    public void testBSTInOrder(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        bst.inOrder();
    }

    @Test
    public void testBSTPostOrder(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        bst.postOrder();
    }
}
