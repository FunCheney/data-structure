## 数据结构学习 data-structure
### 1.线性结构
&ensp;&ensp;在数据元素的非空有限集中:
*  1.存在唯一的一个被称做“第一个”的数据元素；
*  2.存在唯一的一个被称为“最后一个”的数据元素；
*  3.除第一个之外，集合中的每个数据元素均有一个前驱；
*  4.除最后一个之外，结合中的每个数据元素均只有一个后继。

&ensp;&ensp;**线性表**(linear list)是n个数据元素的有限序列。
      
     线性表中元素的个数n(n ≥ 0)定义为线性表的长度，n = 0 时称为空表;
     在非空表中的每个数据元素都有一个确定的位置；
     线性表支持对其中元素的访问，元素的插入、删除等的操作。
#### 1.1 数组
 &ensp;&ensp;线性表的顺序表示是指用一组地址连续的存储单元一次存储线性表的数据元素。数组能够顺序存储相同类型的多个数据。
 访问数组中的某个元素的方法是将其编号然后索引。如果有N个值，它们的编号是0至N-1。
##### 1.1.1 动态数组
 &ensp;&ensp;在申明数组的时，需要指定数组的名称和它包含的类型，在创建数组时，需要指定数组的长度。指定数组的长度后，若改长度不可改变，
 这就一意味着，改数组中不能存放更多的元素。因此，我们需要动态的更新数组容量的大小。
#### 1.2 链表
 &ensp;&ensp;线性表的链式存储结构，由于它不要求逻辑上相邻的元素在物理位置上也相邻，因此它没有顺序存储结构所具有的弱点，但同时
 也失去了顺序表可随机存取的优点。
#### 1.3 队列
#### 1.4 栈
### 2.树结构
&ensp;&ensp;树(Tree)是n(n ≥ 0)个结点的有限集。在任意一棵非空树中:
* 1.有且仅有一个特定的根(root)结点。
* 2.当 n > 1时，其余结点可分为m(m > 0)个互不相交的有限集T1，T2，...Tm,其中每一个集合又是一棵树，称为根的字树（Sub Tree）。

**树结构中的基本术语**

&ensp;&ensp; **结点**包含一个数据元素及若干指向其子树的分支。结点拥有的字树称为**结点的度**。

&ensp;&ensp;度为0的结点称为**叶子结点**，度不为0的结点称为**分支结点**。

&ensp;&ensp; **树的度**是树内各个结点的度的最大值。


#### 2.1 二叉树
 &ensp;&ensp;二叉树是另外一种树型结构，它的特点是每个节点至多只有两颗字树，并且，二叉树的子树有左右之分，其次序不能任意颠倒。
##### 2.1.1.性质:
 * 1.在二叉树的第层i上至多有 $2^{i - 1}$ 个结点。
 * 2.深度为k的二叉树至多有 $2^{k} - 1$ 个结点。
 * 3.对任何一颗二叉树T，如果其终端几点数为 $n_{0}$ ,度为2的节点数为 $n_{2}$ ,则 $n_{0}$ = $n_{2}$ + 1。
 
  满二叉树：一棵深度为k且有$2^{k - 1}$个结点的二叉树称为**满二叉树**。特点：每一层上的结点都是最大的结点数。
  
  完全二叉树：深度为k，有n个结点的二叉树，当前仅当每一个结点都与深度为k的满二叉树中的编号从1至n的结点一一对应时，称之为**完全二叉树**。特点：
  (1)叶子结点只有可能在层次最大的两层上出线。(2)对任一结点，若其右分支下的子孙的最大层次为l，则其左分支下的子孙的最大层次必为l或
  l + 1。
  
  * 4.具有n个几点的完全二叉树的深度为 不大于 $log_{2} n 的整数 + 1
##### 2.1.2.二分搜索树

#### 2.2 平衡树
&ensp;&ensp;二分查找树在极端的情况下会退化成链表，这种情况下时间复杂度为O(n)。
##### 2.2.1 性质:
&ensp;&ensp;它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

##### 2.2.2  AVL 树:

##### 2.2.3 2-3 树:
&ensp;&ensp; **2-结点**：标准二叉树中的结点称为2-结点（含有一个键和两条链接）。

&ensp;&ensp; **3-结点**：包含两个键和三条链接。

**定义**：
一颗2-3查找树或为一棵空树，或由一下结点组成:
* 2-结点，含有一个键（及其对应的值）和两条链接，左链接指向的2-3树中的键都小于该结点，右链接指向的2-3树中的键都大于该结点。
* 3-结点，含有两个键（及其对应的值）和三条链接，左链接指向的2-3树中的键都小于该结点，中链接指向的2-3树中的键都位于该结点的
两个键之间，右链接指向的2-3树中的键都大于该结点。

##### 2.2.4 红黑树:

#### 2.3 堆
 
#### 2.4 集合

### 3.散列表

### 4.图结构
 
