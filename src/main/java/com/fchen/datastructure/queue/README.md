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
 &ensp;&ensp;使用链表实现队列，根据链表的组成，我们需要一个结点类，来表示链表的结点，结点中用来存储当前元素与后继结点的引用。根据队列的属性我们需要
 定义一个结点来表示队列的头，一个结点来表示队列的尾。
 
 下面看链式队列的构造：
 ```
 public class LinkedListQueue<E>{
      class Node<E> {
          public E e;
          public Node next;
      }
     /**
       * 头节点
       */ 
     private Node<E> head;
     
     /**
       * 尾节点
       */
     private Node<E> tail;
 }
```
**链式队列的入队伪代码实现**：
```
ENQUEUE(Q, x)
      if(Q.tail == null){
          Q.tail = x
          Q.head = Q.tail
      } else{
          Q.tail.next = x
          Q.tail = x
      }
      size ++
```

**链式队列的出队伪代码实现**：
  ```
  DEQUEUE(Q)
      if(Q.size == 0){
          error
      } 
      Node cur = Q.head
      Q.head = cur.next
      cur.next = null
      if(Q.head == null){
          Q.tail == null
      }
      size--
      return cur
 ```
 ### 3.循环队列
 &ensp;&ensp;在队列的顺序存储结构中，设置两个指针head和tail分别指向队首所在的位置和队尾所在的位置。
   <div align="center">
      <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/queue/image/loop0.jpg">
   </div>
   
 1. 初始化建空队列时，令head = tail = 0；
 2. 每当插入新的队尾元素时，tail + 1；
 3. 每当删除队首元素时，head + 1。
 
 在非空队列中，头指针始终指向队列头元素，尾指针始终指向队列尾元素的下一个位置。
 
 &ensp;&ensp;使用数组来构造循环队列，我们创建的数组容量为我们需容量 + 1; 之所以加1就是用来记录当循环队列满时，下一个新插入元素的位置，方便我们处理队列满的情况。
 在这种情况下：
 1. data.length = needCapacity + 1    // 创建数组的容量为需要的容量 + 1。便于理解!
 2. tail = data.length - 1            // 当循环队列满时，新插入元素的位置(索引)
 3. (tail + 1) % data.length == head // 此时表示循环队列已满
 
 **循环队列的入队伪代码实现**：
 ```
 ENQUEUE(Q, x)
     if((tail + 1) % data.length == front){
         return "queue is full"
     }
     data[tail] = x
     tail ++
     size ++ 
 ```
 下面以存放11个元素的循环队列尾例，动态显示入队过程：
   <div align="center">
      <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/queue/image/enloopqueue.gif">
   </div>
 
 **循环队列的出队伪代码实现**：
```
DEQUEUE(Q)
       return cur
```
 
 
 ### 4.双端队列
 &ensp;&ensp;双端队列限插入和删除操作在表的两端进行。
 
 
