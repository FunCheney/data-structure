package com.fchen.recursion;

/**
 * @Classname Queens
 * @Description 八皇后问题
 * @Date 2019/7/2 22:11
 * @Author by Chen
 */
public class Queens {
    //定义皇后的数量
    private int queenNum = 8;
    //用来存放皇后最终的位置
    private int[] arr = new int[queenNum];

    //输出一种解法
    private void print(){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    private void check(int n){
        if(n == queenNum){
            //放置第queenNum + 1 个皇后，说明所有皇后已经放置完毕
            print();
            return;
        }
        //依次放入，并判断是否冲突
        for (int i = 0; i < queenNum; i++){
            //把当前的皇后n 放在改行的第一列
            arr[n] = i;
            //判断将当前的第 n 个皇后放在第i列时是否有冲突
            if(judge(n)){
                //不冲突 接着放第 n + 1 个皇后
                check(n + 1);
            }
            //冲突就继续执行arr[n] = i,由于i++ 即将第n个皇后放置在本行的下一列
        }

    }
    /**
     * 判断第n个皇后和前面的n-1个皇后的位置是否冲突
     * @param n
     * @return
     */
    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                //arr[i] == arr[n] 两个皇后的位置在同一列
                //Math.abs(n - i) == Math.abs(arr[n] - arr[i])
                // 第n个皇后是否和第i个皇后在同一斜线上
                return false;
            }
        }
        return true;
    }
}
