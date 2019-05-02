package com.fchen.datastructure.queue;

import com.fchen.datastructure.array.Array;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname QueueTest
 * @Description 数组测试类
 * @Date 2019/4/26 14:27
 * @Author by Fchen
 */
@Slf4j
public class QueueTest {
    @Test
    public void testArrayQueue(){

    }
    @Test
    public void LoopQueue(){
        LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
        for(int i = 0; i < 10; i++){
            loopQueue.enqueue(i);
            log.info(loopQueue.toString());
            if(i % 3 == 2){
                loopQueue.dequeue();
                log.info(loopQueue.toString());
            }
        }
    }

    @Test
    public void LinkedListQueue(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i = 0; i < 10; i++){
            linkedListQueue.enqueue(i);
            log.info(linkedListQueue.toString());
            if(i % 2 == 0){
                linkedListQueue.dequeue();
                log.info(linkedListQueue.toString());
            }
        }
    }
}
