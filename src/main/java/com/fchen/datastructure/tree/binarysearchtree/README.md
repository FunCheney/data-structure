 ### 二分搜索树
 &ensp;&ensp;二分搜索树（BST）是一棵二叉树，其中每个结点都含有一个Comparable的键(以及相关联的值)且每个结点的键都大于其左字树中的任意
 结点的键而小于右子树中任意结点的键。
#### 1.二分搜索树的遍历
* 1.前序遍历(preorder tree walk)

   &ensp;&ensp;输出的根关键字在其左右子树的关键字之前。
* 2.中序遍历(inorder tree walk)

   &ensp;&ensp;输出的根关键字在其左右子树的关键字值之间。（按照顺序输出二叉搜索树中的所有元素）
* 3.后序遍历(postorder tree walk)

   &ensp;&ensp;输出的根关键字在其左右子树的关键字值之后。

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
       TREE-MINMUM(node.right)
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

 #### 4.二分搜索树的插入与删除
 

