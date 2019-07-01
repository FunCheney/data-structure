 ### 二分搜索树
 &ensp;&ensp;二分搜索树（BST）是一棵二叉树，其中每个结点都含有一个Comparable的键(以及相关联的值)且每个结点的键都大于其左字树中的任意
 结点的键而小于右子树中任意结点的键。
#### 1.二分搜索树的构造
##### 1.1 二分搜索树的结点
&ensp;&ensp;一个二分搜索树最多有两个结点，所以我们可以保存直接链接到他们的链。树结点的声明在结构上类似于双链表的声明，二分搜索树结点的声明如下：
```
public class Node<E extends Comparable<E>>{
    public E e;
    /**
     * 左节点
     */
    public Node left;
    /**
     * 右节点
     */
    public Node right;

    public Node(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }
}
```

<div align="center">
     <img src="https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/tree/image/node.jpg">
  </div>
  
##### 1.2 二分搜索树添加结点
 &ensp;&ensp;将一个结点插入二分搜索树。调用如下过程即可完成：
 伪代码如下：
 ```
 INSERT(Node,e)
     while(Node != null){
         //
         Node = new Node(e)
     }
```
其中Node 为该树的根结点，e为要插入的元素
  
##### 1.3 二分搜索树删除结点
  
#### 2.二分搜索树的遍历
* 1.前序遍历(preorder tree walk)

   &ensp;&ensp;输出的根关键字在其左右子树的关键字之前。先输出父结点，在输出左子树和右子树。
   
* 2.中序遍历(inorder tree walk)

   &ensp;&ensp;输出的根关键字在其左右子树的关键字值之间。（按照顺序输出二叉搜索树中的所有元素）先左子树，在输出父结点，最后输出右子树。
* 3.后序遍历(postorder tree walk)

   &ensp;&ensp;输出的根关键字在其左右子树的关键字值之后。先输出左子树，再输出右子树，最后输出父结点。

* 4.层序遍历(广度优先)

 #### 3.二分搜索树的查询
 &ensp;&ensp;在高度为h的二分搜索树上，其查找操作都是在O(h)时间内完成的。
 
**查找**:
 
 &ensp;&ensp;在二分搜索树中查找一个具有关键字的节点。输入一个指向树根的指针和一个关键字k，如果这个结点存在，TREE—SEARCH返回true，否则返回false；
 
 伪代码:
 ```$xslt
TREE-SEARCH(node,k)
    if node == null
        return false;
    if k < node.left
        TREE-SEARCH(node.left, k);
    else if k > node.left
        TREE-SEARCH(node.right, k);
    else 
        return ture; 
```
 java代码实现：
 ```$xslt

```
示例：
 ![alt text](./linkedlist/data-mapper.png "Data Mapper")
 
 **最大、最小关键字元素**:
 
 &ensp;&ensp;从根结点开始，沿着左子树。直到遇到一个左子树为null的节点，返回该节点的元素为这棵树的最小关键元素：
 
 伪代码：
 ```$xslt
TREE-MINMUM(node)
   while(node.left != null)
       TREE-MINMUM(node.left)
   return node.key
```
java代码：
```$xslt

```
&ensp;&ensp;从根结点开始，沿着右子树。直到遇到一个右子树为null的节点，返回该节点的元素为这棵树的最大关键元素：

 伪代码：
 ```$xslt
TREE-MAXMUM(node)
   while(node.right != null)
       TREE-MANMUM(node.right)
   return node.key
```
java代码：
```$xslt

```

&ensp;&ensp;二分搜索树的性质保证了上述两个过程的正确性。
*  1.如果结点node没有左子树，那么由于node右子树中的每个关键字都至少大于或等于node.key，则以node为根的子树中的最小关键字为node.key。
*  2.如果结点node有左子树，那么由于其右子树中没有关键字小于node.key,且在左子树中的每个关键字都不大于node.key,则以node为根的子树中的最小关键字一定在以node.left为根的子树中。
*  3.如果结点node没有右子树，那么由于node左子树中的每个关键字都不大于node.key，则以node为跟的子树中的最大关键字为node.key。
*  4.如果结点node有右子树，那么由于右子树中的所有关键字都不小于node.key，则以node为根的字树中的最大关键字一定在以node.right为根的字树中。

**后继和前驱**:

 &ensp;&ensp;给定一棵二分搜索树中的一个结点，有时需要按中序遍历的方式查找它的后继，如果所有的关键字互补相同，这一个节点node的后继是大于node.key的最小关键字的结点。
 
 伪代码：
 ```
TREE-SUCCESSOR(node)
  if node.right != null
      return TREE-MINMUN(node.right)
  y = node.p
  while y != null && x == node.right
      x = y
      y = y.p
  return y
```
 #### 4.二分搜索树的插入与删除
 

