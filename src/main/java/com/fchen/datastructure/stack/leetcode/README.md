## LeetCode 栈相关习题动画图解与代码实现

[225. Implement Stack using Queues]

**思路**：使用队列A，与队列B来实现栈。栈的特性：后进先出。队列A用作辅助，队列B用来存储元素。
   
* 1.push元素

     首先判断队列A中是否有元素。若有将要添加的元素加入队列B中，然后将A中的元素加入B中；若没有，直接将元素添加到队列A中然后返回。
* 2.pop元素

    判断队列A中有没有元素，若有返回队列A中队首的元素；若没有则返回队列B中队首的元素。

由于上述的1操作，保证新添加的元素(栈顶的元素)始终在队列A的队首，或者在队列B的队首。所以在弹出元素的时候，只需判断A中是否有元素。若有则弹出；
若没有则在队列B中弹出元素。

push元素动态示意图：
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/.jpg">
 </div>
pop元素动态示意图:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/.jpg">
 </div>





[225. Implement Stack using Queues]:https://leetcode.com/problems/implement-stack-using-queues/