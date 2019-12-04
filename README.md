# 数据结构学习 data-structure
## 一. 线性结构
&ensp;&ensp;在数据元素的非空有限集中:
*  1.存在唯一的一个被称做“第一个”的数据元素；
*  2.存在唯一的一个被称为“最后一个”的数据元素；
*  3.除第一个之外，集合中的每个数据元素均有一个前驱；
*  4.除最后一个之外，结合中的每个数据元素均只有一个后继。

&ensp;&ensp;**线性表**(linear list)是n个数据元素的有限序列。
      
     线性表中元素的个数n(n ≥ 0)定义为线性表的长度，n = 0 时称为空表;
     在非空表中的每个数据元素都有一个确定的位置；
     线性表支持对其中元素的访问，元素的插入、删除等的操作。
     
&ensp;&ensp;线性结构的存储方式：**顺序存储结构**和**链式存储结构**。
      
      顺序存储的线性表称为顺序表，顺序表中的存储元素是连续的。
      
      链式存储的线性表称为链表，链表中的存储元素不一定是连续的，元素结点中存放数据元素以及相邻元素的地址信息。 
      
#### 1.1 数组
 &ensp;&ensp;线性表的顺序表示是指用一组地址连续的存储单元一次存储线性表的数据元素。数组能够顺序存储相同类型的多个数据。
 访问数组中的某个元素的方法是将其编号然后索引。如果有N个值，它们的编号是0至N-1。
##### 1.1.1 [动态数组]
 &ensp;&ensp;在申明数组的时，需要指定数组的名称和它包含的类型，在创建数组时，需要指定数组的长度。指定数组的长度后，若改长度不可改变，
 这就一意味着，改数组中不能存放更多的元素。因此，我们需要动态的更新数组容量的大小。
 
##### 1.1.2 有序数组
&ensp;&ensp;有序数组是一种特殊的数组，其中的数据是按照关键字的升序（或降序）排列的，这种排列使得快速查找数据项可以较快速的实现，使用**二分查找**。

&ensp;&ensp;&ensp;&ensp;[数组有序]

&ensp;&ensp;&ensp;&ensp;[二分查找]
 
#### 1.2 [链表]
 &ensp;&ensp;**定义**: 链表是一种递归的数据结构，它或者为空(null),或者指向一个结点(node)的引用,该结点含有一个泛型的元素和一个指向另一结点的引用。

 &ensp;&ensp;线性表的链式存储结构，由于它不要求逻辑上相邻的元素在物理位置上也相邻，因此它没有顺序存储结构所具有的弱点，但同时
 也失去了顺序表可随机存取的优点。
 
 **链表中结点的结构**
 ```
NODE{
    E e        //当前节点的元素
    NODE next  //下一个节点的引用
}
```
#### 1.3 [队列]
 &ensp;&ensp;**定义**: 队列是一种动态集合，他实现的是一种先进先出(first-in,first-out FIFO)策略。
#### 1.4 [栈]
&ensp;&ensp;**定义**: 栈是一种动态集合，他实现的是一种后进先出(first-in,last-out FILO)策略。 
## 二. 非线性结构
### 1. 树结构
&ensp;&ensp;树(Tree)是n(n ≥ 0)个结点的有限集。在任意一棵非空树中:
* 1.有且仅有一个特定的根(root)结点。
* 2.当 n > 1时，其余结点可分为m(m > 0)个互不相交的有限集T1，T2，...Tm,其中每一个集合又是一棵树，称为根的字树（Sub Tree）。

**树结构中的基本术语**

&ensp;&ensp; **结点**包含一个数据元素及若干指向其子树的分支。结点拥有的字树称为**结点的度**。

&ensp;&ensp; 度为0的结点称为**叶子结点**，度不为0的结点称为**分支结点**。

&ensp;&ensp; **树的度**是树内各个结点的度的最大值。

[二叉树]

[平衡树]

### 2. 堆
  
### 3. 集合

### 4. 散列表

### 5. 图结构





[动态数组]:https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/array/README.md
[链表]:https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/linkedlist/README.md
[队列]:https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/queue/README.md
[栈]:https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/stack/README.md
[二叉树]:https://github.com/FunCheney/data-structure/tree/master/src/main/java/com/fchen/datastructure/tree#1-二叉树
[平衡树]:https://github.com/FunCheney/data-structure/tree/master/src/main/java/com/fchen/datastructure/tree#2-平衡树


[数组有序]
[二分查找]
