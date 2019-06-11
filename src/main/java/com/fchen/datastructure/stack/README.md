 ### 栈
 &ensp;&ensp;栈是一种动态集合。在栈(stack)中,被删除的是最近插入的元素：栈实现的是一中**后进先出**(last-in,first-out,LIFO )策略。
 
 &ensp;&ensp;栈上的INSERT操作称为**压栈**(PUSH),而DELETE操作称为**弹栈**(POP)。
 
 栈(接口)中包含的方法：
 ```
 public interface Stack<E> {
     /**
      *获取栈的大小
      * @return
      */
     int getSize();
 
     /**
      * 判断是否为空
      * @return
      */
     boolean isEmpty();
 
     /**
      * 压栈操作
      * @param e
      */
     void push(E e);
 
     /**
      * 弹栈操作
      * @return
      */
     E pop();
 
     /**
      * 获取栈顶的元素
      * @return
      */
     E peek();
 
 }
 ```
 
 #### 使用数组实现栈
 &ensp;&ensp;可以使用一个数组S[1..n]来实现一个栈。该数组有一个属性S.top,指向插入的最新元素。栈中包含的元素为S[1..S.top],其中S[1]为栈低元素，S[S.top]为栈顶元素。
 
 ![alt text](./linkedlist/data-mapper.png "Data Mapper")
 
 &ensp;&ensp;当S.top = 0 时：栈中不包含任何元素，即栈是**空**(empty)的。通过STACK-EMPTY方法来判断一个栈是否为空。
 
 伪代码：
 ```
 STACK-EMPTY
     if S.top == 0
         return TRUE
     return FALSE
```
压栈(伪代码)：
```
PUSH(S,x)
    S.top = S.top + 1
    S[S.top] = x
```
&ensp;&ensp;在数组的容量不可变得情况下，如果S.top超过了数组的初始容量n时，继续压栈，则栈**上溢**(overflow)。

过程展示：

弹栈(伪代码):
```
POP(S,x)
    if STACK-EMPTY(S)
       error "underflow"
    else S.top = S.top - 1
       return S[S.top + 1]
```
&ensp;&ensp;如果试图对一个空栈执行弹栈操作，则称栈**下溢**(underflow)。

过程展示：

获取栈顶的元素(伪代码)：
```
PEEK()
    if STACK-EMPTY(S)
       return null
    else
      retrun S[S.top]
```


 #### 使用单链表来实现栈：
 &ensp;&ensp;使用单链表的顶端插入实现push，通过删除链表的顶端元素实现pop。peek操作只是考察链表顶端元素并返回它的值。


