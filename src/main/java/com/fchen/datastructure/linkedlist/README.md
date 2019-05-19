 ### 链表
 &ensp;&ensp;链表(linked list)是一种这样的数据结构，其中的各个对象按线性排序。数组的线性顺序是由数组下标决定的，然而与数组不同的是，链表的顺序是由各个对象里的指针决定的。
 #### 单向链表(singly linked)
 &ensp;&ensp;为了避免插入和删除的线性开销，需要数据的不连续存储，否则每个元素都可能需要整体移动。
 
 ![alt text](./linkedlist/data-mapper.png "Data Mapper")
 
 #### 双向链表(doubly linked list)
&ensp;&ensp;每一个对象都有一个关键字key和两个指正：next和prev。对象中还可以包含其他的辅助数据(或称为卫星数据)。设x为链表的一个元素，x.next指向它在链表中的后继元素，x.prev则指向它的前驱元素。如果x.prev == null，则x元素没有前驱，因此是链表的第一个元素，即链表头(head)。如果x.next == null，则x没有后继，因此是链表的最后一个元素，即链表尾(tail)。

#### 循环链表(circular linked list)
&ensp;&ensp;表头元素的prev指针指向表尾元素，而表尾元素的next指针则指向表头元素。





