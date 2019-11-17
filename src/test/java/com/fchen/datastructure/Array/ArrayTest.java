package com.fchen.datastructure.Array;

import com.fchen.datastructure.array.Array;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;

import java.util.ArrayList;

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
}
