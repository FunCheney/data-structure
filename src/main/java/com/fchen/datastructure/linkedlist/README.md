 ## 链表
 &ensp;&ensp;链表(linked list)是一种这样的数据结构，其中的各个对象按线性排序。数组的线性顺序是由数组下标决定的，然而与数组不同的是，链表的顺序是由各个对象里的指针决定的。

#### 1.单向链表(singly linked)
 &ensp;&ensp;为了避免插入和删除的线性开销，需要数据的不连续存储，否则每个元素都可能需要整体移动。
 
 单向链表图示:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/linkedlist.jpg">
 </div>
 
**构造单向链表**
```
public class LinkedList<E> {
    /**
     * 链表内部的节点类
     */
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





