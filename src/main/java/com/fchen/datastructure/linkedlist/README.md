 ## 链表
 &ensp;&ensp;链表(linked list)是一种这样的数据结构，其中的各个对象按线性排序。数组的线性顺序是由数组下标决定的，然而与数组不同的是，链表的顺序是由各个对象里的指针决定的。
### 1.单向链表(singly linked)
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
#### 1.1 (单)链表的插入
&ensp;&esnp;给定某一元素e,通过LIST-INSERT将其添加到链表中给定的某一位置。

伪代码如下：
```
LIST-INSERT(index,e)
    if index < 0 or index > size
        throw new IllegalArgumentException("Index Illegal")
    Node cur = L.head  //虚拟的头结点
    while i < index
        cur = cur.next
        i++
    // 当前节点的下一结点为新加入的结点
    // 新加入节点的下一节点为当前结点的下一结点
    cur.next = Node(e,cur.next) 
    size++ 
```
示例图如下：
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/linkedadd.gif">
 </div>
 
 &ensp;&ensp;向链表中的第一个位置，或者最后一个位置加入元素，调用上述的过程即可完成相应的操作。
 
#### 1.2 (单)链表的删除
&ensp;&ensp;给定某一位置的节点，使用LIST-DELETE将其删除。并返回该节点的关键字key
```
LIST-DELETE(index)
     if index < 0 or index > size
           throw new IllegalArgumentException("Index Illegal")
     Node cur = L.head  //虚拟的头结点
     while(i < index)
         cur = cur.next
         i++
     Node delNode = cur.next
     cur.next = delNode.next
     delNode.next = null
     size--
     return delNode.key
```
&ensp;&ensp;给定某一结点的引用，使用LIST-DELETE将其删除。
```
LIST-DELETE(E e)
    delNode = LIST-SEARCH(e)
    if(delNode != null){
        Node cur = L.head
        Node prev = L.head.next
        while prev.key != e
            cur = cur.next
            prev = prev.next
        cur.next = delNode.next
        delNode.next = null
        size --
    }else{
        error
    }
        
```

示例图如下：
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/linkedremove.gif">
 </div>
 
  &ensp;&ensp;删除链表中的第一个或者最后一个结点，调用上述的过程即可完成相应的操作。

#### 1.2 (单)链表的搜索
&ensp;&ensp;过程LIST—SEARCH(e)采用简单的线性搜索方法，用于查找链表中第一个关键字为e的元素，并返回该结点。如果链表中没有关键字为e的对象，则返回空结点。

伪代码：
```
LIST-SEARCH(e)
    Node cur = L.head  //虚拟的头结点
    while cur != null and cur.key != e
        cur = cur.next
    return cur
```
&ensp;&ensp;过程LIST—SEARCH(index)查找链表中某一位置的结点。

伪代码:
```
LIST-SEARCH(index)
    Node cur = L.head 
    while i < index
        cur = cur.next
        i++
    return cur
```
 
 [单向链表Api Java实现]
### 2.双向链表(doubly linked list)
&ensp;&ensp;每一个对象都有一个关键字key和两个指正：next和prev。对象中还可以包含其他的辅助数据(或称为卫星数据)。设x为链表的一个
元素，x.next指向它在链表中的后继元素，x.prev则指向它的前驱元素。如果x.prev == null，则x元素没有前驱，因此是链表的第一个元素，
即链表头(head)。如果x.next == null，则x没有后继，因此是链表的最后一个元素，即链表尾(tail)。属性L.head指向链表的第一个元素。如果
L.head=null，则链表为空。

 双向链表图示:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/doublelist.jpg">
 </div>
 
 **双链表的结点类**
 ```
 class NODE{
     E e;
     NODE prev;
     NODE next;
 }
```
 
#### 2.1 (双)链表的搜索
&ensp;&ensp;单链表的搜索与双链表的搜索类似。搜索一个有n个对象的链表，过程LIST-SEARCH最坏的情况下的运行时间为O(n),因为可能需要搜索整个链表。
 
#### 2.1 (双)链表的插入
&ensp;&ensp;给定某一元素e,通过LIST-INSERT将其添加到链表中给定的某一位置。
```
LIST-INSERT(index,e)
    if index < 0 or index > size
        throw new IllegalArgumentException("Index Illegal")
    NODE cur = L.head  // 链表的头结点
    while i < index
        cur = cur.next
        i++  
   // 要插入的结点
   NODE insertNode = new NODE(e,cur,cur.next);
   // 当前结点的下一结点为要插入的结点
   cur.next = insertNode;
   // 要插入结点的下一结点
   Node insertNodeNext = insertNode.next;
   if(insertNodeNext != null){
       //要插入结点的下一结点的前一结点 为 要插入结点
       insertNodeNext.prev = insertNode;
   }
   size++;
```
&ensp;&ensp;给定某一关键字key为e的结点node,通过LIST-INSERT将其添加到链表的前端。(哨兵后移)
```
LIST-INSERT(NODE node)
    node.next = L.head //链表的头结点
    if L.head != null
        L.head.prev = node
    L.head = node
    node.prev = null
    size++
```
  
#### 2.1 (双)链表的删除
&ensp;&ensp;过程LIST-DELETE将一个元素e从链表中删除。该过程需要给定一个指向x的指针，然后通过修改一些指针，将该元素删除。如果要删除具有给定具有关键字值的元素，则需先调用LIST-SEARCH找到该元素。

伪代码：
```
LIST-DELETE(NODE node)
    if node.prev != null
        node.prev.next = node.next
    else
        L.head = node.next
    if node.next != null
        node.next.prev = node.prev 
```
 
### 3.循环链表(circular linked list)
&ensp;&ensp;表头元素的prev指针指向表尾元素，而表尾元素的next指针则指向表头元素。

单向链表和双向链表都可以有循环链表，下面以双向链表为例:
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/circular.jpg">
 </div>
 
&ensp;&ensp;**哨兵**(sentinel)是一个哑对象，其作用是简化边界条件的处理。例如，假设在链表L中设置一个对象L.nil,该对象代表NIL，但是也具有和其他对象相同的各个属性。对于链表代码中出现的每一处NIL的引用，都以对哨兵L.nil的引用。
#### 3.1 有哨兵的双向循环链表(circular，doubly linked list with a sentinel)
&ensp;&ensp;哨兵L.nil位于表头和表尾之间。属性L.nil.next指向表头，L.nil.prev指向表尾。类似的表尾的next属性和表头的prev属性同时指向L.nil。因为L.nil.next指向表头，就可以去掉属性L.head，并把对它的引用代替为对L.nil.next的引用。

示例图如下：
 <div align="center">
    <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/image/sentinel.jpg">
 </div>
 
 &ensp;&ensp;哨兵L.nil 位于表头和表尾之间。由于可通过L.nil.next访问表头，属性L.head就不需要了。
 
 #### 3.2 (循环)链表的搜索
 伪代码：
 ```
 LIST-SEARCH(e)
     Node cur = L.nil.next //第一个节点
     while cur != null and cur.key != e
         cur = cur.next
     return cur
 ```
 
 #### 3.3 (循环)链表的插入
 
 #### 3.4 (循环)链表的删除
 
## Java实现
[单向链表Api Java实现]

[双向链表Api Java实现]

[循环链表Api Java实现]



