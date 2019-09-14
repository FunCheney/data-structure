### 红黑树(read-black tree)
 &ensp;&ensp;红黑树也是一种平衡搜索树，他可以保证在最坏的情况下基本动态集合操作的时间复杂度为O(lgn)。
 
 &ensp;&ensp;红黑树是一棵二分搜索树，它在每个位置上增加了一个存储位来表示节点的颜色，可以是RED或BLACK。通过任何一条从根到叶子的简单路径上各个结点的颜色进行约束，红黑树确保没有一条路径会比其他路径常出两倍，因而近似于平衡的。
 
#### 红黑树的构成：
 
 * 节点
 &ensp;&ensp;树中的结点包含5个属性：color、key、left、right、和p。
 
 java代码:
 ```
public class Node{
       /** 键*/
       public K key;
       /** 相关联的值*/
       public V value;
       /** 左右子树*/
       public Node left,right;
       /** 父结点指向该结点的颜色*/
       public boolean color;
       public Node(K key, V value){
           this.key = key;
           this.value = value;
           left = null;
           right = null;
           color = RED;
       }
   }
```
 
#### 红黑树图示：
 
 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_3.gif">
</div>
 
#### 红黑树的性质
  
  * 1.每个节点或是红色的，或是黑色的；
  
  * 2.根结点是黑色的；
  
  * 3.每个叶子结点(空链接)是黑色的；
  
  * 4.如果一个结点是红色的，则它的两个叶子结点都是黑色的；
  
  * 5.对每一结点，从该结点到其所有后代叶结点的简单路径上，均包含有相同数目的黑色结点。
 
#### 旋转

&ensp;&ensp;在对红黑树进行操作(插入或删除)的时候，可能会出现右链接为红色链接，或者有两条连续的红色链接。这样一来就破坏红黑树的性质。因此需要
在本次操作完成之前通过旋转使得本次操作后，该树仍然是红黑树。旋转操作会改变红链接的指向。旋转也分为**左旋转**和**右旋转**。

&ensp;&ensp;左旋转：将红色连接为右链接转化为左链接。图示如下：

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_4.gif">
</div>

总结:

&ensp;&ensp;上述图片中，结点值为8的结点颜色可以是红色，夜可以是黑色。该结点同样也可是左子树，也可以是右子树。上述左旋转的过程：将上述图片的部分看成一棵子树，该子树的根结点的值是8。经过旋转后将值为15的结点作为该树的根结点。(将两个键中值较小的左为跟结点变成值交大者作为根结点的过程)。

* 左旋转的代码实现：
```
private Node leftRotate(Node node){
    Node x = node.right;
    //左旋转
    node.right = x.left;
    x.left = node;

    x.color = node.color;
    node.color = RED;
    return x;
}
```


&ensp;&ensp;右旋转：将红色连接为左链接转化为右链接。图示如下：

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_5.gif">
</div>

总结：

&ensp;&ensp;红黑树右旋转的过程就是左旋转的逆向过程。

* 右旋转的代码实现:
```
private Node rightRotate(Node node){
    Node x = node.left;
    node.left = x.right;
    x.right = node;

    x.color = node.color;
    node.color = RED;
    return x;
}
```
  
#### 红黑树的操作
 
##### 插入
&ensp;&ensp;为了更好的理解红黑树，在上一篇文章中首先学习了2-3树，这一篇文章中关于红黑树的学习，也是通过2-3树经过相应的变化而来。这里要对红黑树
进行插入结点的操作，同样类比2-3树的插入。来看看，在红黑树的插入过程中，是如何维护红黑树的性质的。

&ensp;&ensp;在红黑树的插入操作中，假设插入的节点都为红色。

这里假设结点为红色，插入红黑树之后，会破坏上述的性质4。通过上述的旋转过程可以进行相应的调整来维护红黑树。这里如果假设插入的是黑色的结点，就会破坏红黑树的平衡性(性质5)。

##### 向2-结点中插入新键
&ensp;&ensp;向**2-结点**中插入新键分为如下的两种情况。

###### 红黑树根结点的左侧插入
&ensp;&ensp;在红黑树的根结点的左侧插入，默认插入是红结点，而红黑树根结点为黑节点，插入该结点后，红黑树的性质不变。

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_insert_0.jpg">
</div>


###### 红黑树根结点的右侧插入
&ensp;&ensp;在红黑树的根结点的右侧插入，由于默认插入的是红色结点，插入后不满足红黑树的性质，此时右节点为红色结点。通过左旋转，将其旋转为左结点为红色结点，修正根结点的连接。

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_insert_1.gif">
</div>

总结：

&ensp;&ensp;经过上述操作后，该红黑树等价为一棵只有一个**3-结点的**2-3树，该红黑树有两个结点，其中一个为红色结点，树的黑高为1。

##### 向树底部的2-结点中插入新键
&ensp;&ensp;用和二分搜索树相同的方式向一棵红黑树中插入一个新键会在树的底部新增一个结点(保证树的有序性)，同样也是红结点和其父结点相连。如果父结点是一个2-结点，那么上述的两种处理方式仍然适用。如果指向新结点的是父结点的左链接，那么父结点就直接成为一个**3-结点**；如果指向新结点的是父结点的右链接，这就是一个错误的**3-结点**，通过一次左旋转来修正。

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_insert_2.gif">
</div>

##### 向一棵双键树(3-结点)中插入新键
&ensp;&ensp;双键树中插入新的键分为如下的三种情况，下面分类讨论：

###### 新插入的键大于原树中的两个键
&ensp;&ensp;要插入的键在大于原树中的两个键，此时根结点链接两个红结点，不符合红黑树的性质，只需将两个红色节点变为黑色节点即可。

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_insert_3.gif">
</div>

###### 新插入的键介于原树中的两个键之间
&ensp;&ensp;新插入的键介于原树两个键之间，这会产生两个连续的红色结点，一个结点是左结点，一个结点是右结点。需要将红色的右结点先左旋转变，使其变成两个连续的红色结点；然后在进行右旋转使其变成一个结点链接两个红色的结点(一左一右)；最后在对两个红色结点的颜色进行变换。

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_insert_4.gif">
</div>

###### 新插入的键小于原树中的两个键
&ensp;&ensp;新插入的键小于原树中的两个键，新插入的结点会被链接到最左边的空链接，这样也产生了两个连续的红色结点，将从根结点开始的第一个红结点右旋转，使根结点链接两个红色的结点；然后，将两个红色结点的颜色变为黑色。

 <div align="center">
       <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/rbTree_insert_5.gif">
</div>

##### 颜色转换
&ensp;&ensp;当一个结点链接两个红色的子结点时，需要将子结点的颜色右红变黑，同时也需要将父结点的颜色由黑变红。

代码实现
```
private void flipColors(Node node){
    node.color = RED;
    node.left.color = BLACK;
    node.right.color = BLACK;
}
```

##### 根结点总是黑色的
&ensp;&ensp;在发生颜色转换的时候，会遇到根结点链接连个红色结点的情况。此时进行颜色转换后根结点为红色，当红色及结点出现在根结点的时候，红黑树的黑高就会增加1。上篇文章中有说到，2-3树的节点与红黑树结点的对应关系。而红色结点的来源就是3-结点拆成两个2结点，然后将左2-结点标记为红色。在每次添加新的结点后，都将红黑树的根结点设置为黑色。




##### 删除






















