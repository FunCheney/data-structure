 ### 红黑树(read-black tree)
 &ensp;&ensp;红黑树也是一种平衡搜索树，他可以保证在最坏的情况下基本动态集合操作的时间复杂度为O(lgn)。
 
 &ensp;&ensp;红黑树是一棵二分搜索树，它在每个位置上增加了一个存储位来表示节点的颜色，可以是RED或BLACK。通过任何一条从根到叶子的简单路径上各个结点的颜色进行约束，红黑树确保没有一条路径会比其他路径常出两倍，因而近似于平衡的。
 
 #### 红黑树的构成：
 
 * 节点
 &ensp;&ensp;树中的结点包含5个属性：color、key、left、right、和p。
 
 #### 红黑树图示：
 
 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_3.gif">
   </div>
 
  #### 红黑树的性质
  
  * 1.每个节点或是红色的，或是黑色的；
  
  * 2.根结点是黑色的；
  
  * 3.每个叶子结点(空链接)是黑色的
  
  * 4.如果一个结点是红色的，则它的两个叶子结点都是黑色的
  
  * 5.对每一结点，从该结点到其所有后代叶结点的简单路径上，均包含有相同数目的黑色结点。
 
 #### 红黑树的操作
 
 ##### 旋转
 ##### 插入
 ##### 删除
