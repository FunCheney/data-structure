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
  
  * 3.每个叶子结点(空链接)是黑色的
  
  * 4.如果一个结点是红色的，则它的两个叶子结点都是黑色的
  
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
##### 删除
