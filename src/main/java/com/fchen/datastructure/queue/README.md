 ## 队列
 &ensp;&ensp;队列是一种动态集合，在队列(queue)中,被删除的总是在集合中存在时间最长的元素：队列实现的是一种先进先出(first-in,first-out FIFO)策略。
 
  &ensp;&ensp;队列上的insert操作称为**入队**(ENQUEUE)，delete操作称为**出队**(DEQUEUE)。队列有**队头**(head)和**队尾**(tail),当有一个元素入队时，
  它被存放在队尾的位置；当有一个元素出队时，该元素是队头的位置。
  
  <div align="center">
     <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/queue/image/queue1.jpg">
  </div>
  
 **入队操作伪代码实现**:
 ```
  ENQUEUE(Q, x)
       Q[Q.tail] = x
       if Q.tail == Q.length
           Q.tail = 1
       else
           Q.tail  = Q.tail + 1
  ```
 **出队操作伪代码实现**:
 ```
 DEQUEUE(Q)
     x = Q[Q.head]
     if Q.head == Q.length
         Q.head = 1
     else
         Q.head = Q.head + 1
     return x
```
**队列的接口中的API**
```
public interface Queue<E> {
    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 队列大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取队首的元素
     * @return
     */
    E getFront();

}
```
 ###  1.使用数组实现队列
 &ensp;&ensp;使用数组(array)实现队列，通过数组的索引,我们可以非常简单的完成队列的实现，队列的入队与出队操作。使用数组实现的队列，该队列的队头(Q.head)
 在数组中索引为0位置。队尾(Q.tail)在数组中索引为(array.length)的位置。

**队列出队示意图**:
<div align="center">
     <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/queue/image/dequeue.gif">
  </div>

**队列入队示意图**:
  <div align="center">
     <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/queue/image/enqueue.gif">
  </div>
  
 ###  2.使用链表实现队列
 
 
 ###  3.循环队列
 ![alt text](./linkedlist/data-mapper.png "Data Mapper")
 
 
