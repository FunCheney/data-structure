## LeetCode 栈相关习题动画图解与代码实现

[225. Implement Stack using Queues]

#### 栈的构造:
**思路**：使用队列A，与队列B来实现栈。栈的特性：后进先出。

代码实现:
```
public class MyStack {
    Queue<Integer> queueA;
    Queue<Integer> queueB;
    /** Initialize your data structure here. */
    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) { }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {}

    /** Get the top element. */
    public int top() {
        return queueA.isEmpty() ? queueB.peek() : queueA.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() ? queueB.isEmpty() : queueA.isEmpty();
    }

```
**1.push元素**

 &ensp;&ensp;首先判断队列A中是否有元素。
  
* 1.没有将新增的元素加入到队列A中，然后在判断队列B里面是否有元素。

    * a. 若有，将队列B中的元素依次出队，然后添加到队列A里面。
   
    * b.若没有，则结束本次添加
* 2.若有将要添加的元素加入队列B中，然后将A中的元素依次加入B中。

思路：利用队列的 First-In-First-Out 特性 太实现 栈的 First-In-Last-Out。在添加元素的时候确保每次添加的时候都有一个队列为空。
每次条件一个元素都要讲不为空的队列中的元素加到空队列中去。

代码实现：
```
public void push(int x) {
        if(queueA.isEmpty()){
            queueA.add(x);
            while (!queueB.isEmpty()){
                queueA.add(queueB.remove());
            }
        }else{
            queueB.add(x);
            while (!queueA.isEmpty()){
                queueB.add(queueA.remove());
            }
        }
    }
```

示意图：
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/circular.jpg">
 </div>
     
**2.pop元素**

   判断队列A中有没有元素，若有返回队列A中队的元素；若没有则返回队列B中队的元素。

代码实现：
```
public int pop() {
        if(!queueA.isEmpty()){
            return queueA.remove();
        }else{
            return queueB.remove();
        }

    }
```




[225. Implement Stack using Queues]:https://leetcode.com/problems/implement-stack-using-queues/