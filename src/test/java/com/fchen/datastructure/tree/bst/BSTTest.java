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

    @Test
    public void testBstPreOrderNR(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        bst.preOrderNR();
    }
    @Test
    public void testBstLevelOrder(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        bst.levelOrder();
    }

    @Test
    public void testBstRemoveMin(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        Integer min = bst.removeMin();
        log.info("min elm is:{}",min);
    }

    @Test
    public void testBstRemoveMax(){
        BST<Integer> bst = new BST<>();
        int arr[] = {5,3,6,8,4,2};
        for(int num : arr){
            bst.add(num);
        }
        Integer max = bst.removeMax();
        log.info("min elm is:{}",max);
    }
}
