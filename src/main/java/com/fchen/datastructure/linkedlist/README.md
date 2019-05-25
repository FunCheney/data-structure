 ## 链表
 &ensp;&ensp;链表(linked list)是一种这样的数据结构，其中的各个对象按线性排序。数组的线性顺序是由数组下标决定的，然而与数组不同的是，链表的顺序是由各个对象里的指针决定的。

#### 1.单向链表(singly linked)
 &ensp;&ensp;为了避免插入和删除的线性开销，需要数据的不连续存储，否则每个元素都可能需要整体移动。
 
 单向链表图示:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/linkedlist.jpg">
 </div>
 
 **单链表的节点类**
 ```
 private class Node{
        /**
         * 元素
         */
        public E e;
        /**
         * 下一节点
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public  Node(){
            this(null,null);
        }
    }
```
 
**构造单向链表**
```
public class LinkedList<E> {
    /**
     * 单链表结点 内部类
     */
    private class Node{}
    
     /**
       * 虚拟的头结点
       */
     private Node dummyHead;
    
     private int size;
    
     public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
     }   
}
``` 

#### 2.双向链表(doubly linked list)
&ensp;&ensp;每一个对象都有一个关键字key和两个指正：next和prev。对象中还可以包含其他的辅助数据(或称为卫星数据)。设x为链表的一个
元素，x.next指向它在链表中的后继元素，x.prev则指向它的前驱元素。如果x.prev == null，则x元素没有前驱，因此是链表的第一个元素，
即链表头(head)。如果x.next == null，则x没有后继，因此是链表的最后一个元素，即链表尾(tail)。属性L.head指向链表的第一个元素。如果
L.head=null，则链表为空。

 双向链表图示:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/doublelist.jpg">
 </div>
 
#### 3.循环链表(circular linked list)
&ensp;&ensp;表头元素的prev指针指向表尾元素，而表尾元素的next指针则指向表头元素。

单向链表和双向链表都可以有循环链表，下面以双向链表为例:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/circular.jpg">
 </div>
 
&ensp;&ensp;**哨兵**(sentinel)是一个哑对象，其作用是简化边界条件的处理。例如，假设在链表L中设置一个对象L.nil,该对象代表NIL，但是也具有和其他对象相同的各个属性。对于链表代码中出现的每一处NIL的引用，都以对哨兵L.nil的引用。
##### 3.1 有哨兵的双向循环链表(circular，doubly linked list with a sentinel)
&ensp;&ensp;哨兵L.nil位于表头和表尾之间。属性L.nil.next指向表头，L.nil.prev指向表尾。类似的表尾的next属性和表头的prev属性同时指向L.nil。因为L.nil.next指向表头，就可以去掉属性L.head，并把对它的引用代替为对L.nil.next的引用。

示例图如下：
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/sentinel.jpg">
 </div>




