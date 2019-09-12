 ## 1. 二叉树
  &ensp;&ensp; 二叉树是另外一种树型结构，它的特点是每个节点至多只有两颗字树，并且，二叉树的子树有左右之分，其次序不能任意颠倒。
 ##### 性质:
  * 1.在二叉树的第层i上至多有 $2^{i - 1}$ 个结点。
  * 2.深度为k的二叉树至多有 $2^{k} - 1$ 个结点。
  * 3.对任何一颗二叉树T，如果其终端几点数为 $n_{0}$ ,度为2的节点数为 $n_{2}$ ,则 $n_{0}$ = $n_{2}$ + 1。
  
   满二叉树：一棵深度为k且有$2^{k - 1}$个结点的二叉树称为**满二叉树**。特点：每一层上的结点都是最大的结点数。
   
   完全二叉树：深度为k，有n个结点的二叉树，当前仅当每一个结点都与深度为k的满二叉树中的编号从1至n的结点一一对应时，称之为**完全二叉树**。特点：
   (1)叶子结点只有可能在层次最大的两层上出线。(2)对任一结点，若其右分支下的子孙的最大层次为l，则其左分支下的子孙的最大层次必为l或
   l + 1。
   
   * 4.具有n个几点的完全二叉树的深度为 不大于 $log_{2} n 的整数 + 1
 ##### 1.1.2.二分搜索树
 
 ## 2. 平衡树
 &ensp;&ensp;二分查找树在极端的情况下会退化成链表，这种情况下时间复杂度为O(n)。
 ##### 性质:
 &ensp;&ensp;它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 
 ### 2.1  AVL 树:
  &ensp;&ensp;AVL(Adelson-Velskii 和 Landis)树是带有平衡条件(balance condition)的二分搜索树。
 
 ### 2.2  2-3 树:
 &ensp;&ensp; **2-结点**：标准二叉树中的结点称为2-结点（含有一个键和两条链接）。
 
 &ensp;&ensp; **3-结点**：包含两个键和三条链接。
 
 **定义**：
 一颗2-3查找树或为一棵空树，或由一下结点组成:
 * 2-结点，含有一个键（及其对应的值）和两条链接，左链接指向的2-3树中的键都小于该结点，右链接指向的2-3树中的键都大于该结点。
 * 3-结点，含有两个键（及其对应的值）和三条链接，左链接指向的2-3树中的键都小于该结点，中链接指向的2-3树中的键都位于该结点的
 两个键之间，右链接指向的2-3树中的键都大于该结点。
 
 **示意图:**
 
  <div align="center">
     <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/2-3-tree.jpg">
  </div>
  
  [2-3 树的操作]

 ### 2.3 红黑树
 
 #### 红黑树与 2-3查找树
 &ensp;&ensp;红黑树是2-3查找树的一种表示方式。区别在于，2-3查找树中包含有**2-结点**与**3-结点**。在红黑树中只有所有的结点都是**2-结点**，这样一来就会有这样的疑问，既然都是**2-结点**，那怎么表示2-3树呢? 答案就是，在红黑树中，对2-3树中的**3-结点**做了一定的处理，通过使用**2-结点**和一些其他的信息来表示**3-结点**。
 
 **红黑树中对2-3树中的3-结点的处理**
 
 &ensp;&ensp;将2-3树中的**3-结点**拆分成2个**2-结点**，并将这两个**2-结点**的左节点使用红色的链接，右连接使用黑色(原来2-3树中的链接)链接，连在一起。如下图：
 
 <div align="center">
      <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_0.jpg">
  </div>
 
 这样一来，就得到了构造红黑树的基本思想：
 
 &ensp;&ensp;**用标准的二分搜索树(完全由2-结点构成)和一些额外的信息(替换3-节点)来表示2-3树**。
 
 从上面的描述我们可以得到红黑树的定义：
 
&ensp;&ensp;红黑树是含有红黑链接并满足下列条件的二分搜索树：
 
&ensp;&ensp; 1. 红链接均为左链接；

&ensp;&ensp; 2. 没有任何一个结点同时和两条红链接相连；
  
&ensp;&ensp; 3. 该树是**完美平衡**的，即任意空链接到根结点的路径上黑链接的数量相同。


红黑树中连接的分类：
 
&ensp;&ensp;1. 红链接将两个2-结点连接起来构成一个3-结点；
 
&ensp;&ensp;2. 黑链接则是2-3树中的普通链接。
 
 如下图所示：
 
 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_1.jpg">
   </div>
 
 #### 红黑树中颜色替换
 &ensp;&ensp;为了方便表示红黑树，间红黑树中链接的颜色表示在该链接所连接的结点中，我们都知道，一条链接的两端，有两个结点(父子结点)，将连接的颜色保存在子节点中。做颜色替换后，红黑树的示意图如下：
 
  <div align="center">
        <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_2.jpg">
    </div>
 上面图片左侧的部分，在链接的旁边都有一个数字，这个数字称为：**黑高。**
 
 黑高(black-height)定义：
 
 &ensp;&ensp; 从某个结点出发(不含该结点)到达一个叶子结点的任意一条简单路径上的黑色链接(结点)的个数。
 
 &ensp;&ensp; 通过上述的黑高定义，及红黑树的平衡性可以知道**红黑树的黑高就是根结点的黑高**。
 
 
 
 [红黑树的操作]
 
 [红黑树的操作]:https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/redblacktree/README.md
 
 [2-3 树的操作]:https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/23searchtree/README.md
 
