package com.fchen.datastructure.Array;

import com.fchen.datastructure.array.Array;
import com.fchen.datastructure.array.apply.Algorithm06;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Classname ArrayTest
 * @Description 数组测试类
 * @Date 2019/4/26 14:27
 * @Author by Fchen
 */
@Slf4j
public class ArrayTest {
    @Test
    public void testArray(){
        Array<Integer> array = new Array<>(20);
        String arrStr[] = {"1","2"};
        Array<String> arr = new Array<>(arrStr);
        for (int i = 0; i < 10; i++){
            array.addLast(i);
        }
        log.info(array.toString());
        array.addLast(100);
        log.info(array.toString());
        array.addFirst(-1);
        log.info(array.toString());
        array.remove(3);
        log.info(array.toString());
        array.removeElement(4);
        log.info(array.toString());
        for(int i = 0; i < 4; i++){
            array.removeFirst();
        }
        log.info(array.toString());
        array.removeFirst();
        log.info(array.toString());
    }
    @Test
    public void test(){
        int[] arr = {1,1,1,1,2,2,2,2};
        Algorithm06 algorithm06 = new Algorithm06();
        int[] prefect = algorithm06.prefect(arr, 4);
        System.out.println(Arrays.toString(prefect));
    }
}
