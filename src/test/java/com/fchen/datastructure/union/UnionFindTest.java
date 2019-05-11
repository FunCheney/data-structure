package com.fchen.datastructure.union;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @Classname UnionFindTest
 * @Description TODO
 * @Date 2019/5/11 23:25
 * @Author by Chen
 */
@Slf4j
public class UnionFindTest {
    private double testUF(UF uf,int m){
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < m; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }
        for(int i = 0; i < m; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }

        long endTime = System.currentTimeMillis();
        return  (endTime - startTime) / 1000.0;
    }

    @Test
    public void test(){
        int size = 10000;
        int m = 10000;
        UnionFind1 unionFind1 = new UnionFind1(size);
        log.info("time1:{}",testUF(unionFind1,m));
        UnionFind2 unionFind2 = new UnionFind2(size);
        log.info("time2:{}",testUF(unionFind2,m));
    }
}
