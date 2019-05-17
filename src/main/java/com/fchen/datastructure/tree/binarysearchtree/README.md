 ### 二叉树
 &ensp;&ensp;二叉树是另外一种树型结构，它的特点是每个节点至多只有两颗字树，并且，二叉树的子树有左右之分，其次序不能任意颠倒。
 #### 1.性质:
 * 1.在二叉树的第层i上至多有 $2^{i - 1}$ 个结点。
 * 2.深度为k的二叉树至多有 $2^{k} - 1$ 个结点。
 * 3.对任何一颗二叉树T，如果其终端几点数为 $n_{0}$ ,度为2的节点数为 $n_{2}$ ,则 $n_{0}$ = $n_{2}$ + 1。
 
  满二叉树：一棵深度为k且有$2^{k - 1}$个结点的二叉树称为**满二叉树**。特点：每一层上的结点都是最大的结点数。
  
  完全二叉树：深度为k，有n个结点的二叉树，当前仅当每一个结点都与深度为k的满二叉树中的编号从1至n的结点一一对应时，称之为**完全二叉树**。特点：
  (1)叶子结点只有可能在层次最大的两层上出线。(2)对任一结点，若其右分支下的子孙的最大层次为l，则其左分支下的子孙的最大层次必为l或
  l + 1。
  
  * 4.具有n个几点的完全二叉树的深度为 不大于 $log_{2} n 的整数 + 1
#### 2.二分搜索树的遍历
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
* 1 如果节点node没有左子树，那么由于node右子树中的每个关键字都至少大于或等于node.key，则以node为根的子树中的最小关键字为node.key。
* 2 如果结点node有左子树，那么由于其右子树中没有关键字小于node.key,且在左子树中的每个关键字都不大于node.key,则以node为根的子树中的最小关键字一定在以node.left为根的子树中。

 #### 4.二分搜索树的插入与删除
 

