 ### 动态数组
 #### 1 数组示意图:
  ![image](https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/array/image/arr.png "arr")
 ##### 1.1 动态数组的初始化
 ```
/**
 * 存储数组中元素
 */
private E[] data;

/**
 * 数组中存储元素的个数
 */
private int size;

/**
 * 有参构造函数
 * @param capacity 数组容量
 */
public Array(int capacity){
    data = (E[])new Object[capacity];
    size = 0;
}

/**
 * 传入数组方式构建动态数组
 * @param arr
 */
public Array(E[] arr){
    data = (E[]) new Object[arr.length];
    for (int i = 0; i < arr.length; i++){
        data[i] = arr[i];
    }
    size = arr.length;
}
/**
 * 无参构造函数 默认数组容量为10
 */
public Array() {
    this(10);
}
```
##### 1.2 数组的动态
###### 1.2 .1 扩容
&ensp;&ensp;当数组中的元素超过数组的容量时，动态的修改数组的容量。(1)新建一个临时数组容量变为原来的3/2倍；(2)将原数组中的元素复制到临时数组中;
(3)将临时数组指向原来的数组。

伪代码：
```
RESIZE(data, size, length)
    E[] newData =  new E[length]
    for(int i = 0; i < size; i++)
        newData[i] = data[i]
    data = newData
```
java代码：
```
private void resize(int newCapacity){
    E[] newData = (E[])new Object[newCapacity];
    for(int i = 0; i < size; i++){
        newData[i] =data[i];
    }
    data = newData;
}
```
示意图:

![image](https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/array/image/arrResize1.gif "arrResize")

###### 1.2.2.缩容
 &ensp;&ensp;删除数组中的元素时，当数组中元素的个数为原数组的 1/4 时动态的修改数组的容量。(1)新建一个临时数组容量变为原来的1/2倍；(2)将原数组中的元素复制到临时数组中;
 (3)将临时数组指向原来的数组。
 
 示意图:
 ![image](https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/array/image/arrResize2.gif "arrResize2")
 
#### 2 数组的操作:
##### 2.1 数组中添加元素(添加在某一索引):
* 1.先判断要添加的索引位置是否正常
* 2.首先判断数组中个数，是否等于数组容量

      a.若超过则先扩容。
* 3.将要添加索引位置及其后的所有元素均向后移动
* 4.将该元素发到要添加的索引位置
* 5.维护数组中元素个数

伪代码:
```
ADD-INDEX(e,index):
    if(index < 0 || index > size)
        throw new ArrayIndexOutOfBoundsException("index out of bound")
    if(size == data.length)
        RESIZE(data.length + (data.length >> 1))
    for(i = size - 1; i >= index; i--)
        data[i + 1] = data[i]
    data[index] = e
    size++
```
java代码实现:
```
public void addIndex(E e,int index){
    if(index < 0 || index > size){
        throw new ArrayIndexOutOfBoundsException("index out of bound");
    }
    if(size == data.length){
        resize(data.length + (data.length >> 1));
    }
    for (int i = size - 1; i >= index; i--) {
        data[i + 1] = data[i];
    }
    data[index] = e;
    size ++;
}
```
添加元素示意图:
![image](https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/array/image/add.gif "add")

##### 2.2 数组中删除元素(删除某一索引的元素):
* 1.首先验证要删除索引的合法性
* 2.删除该索引位置的元素(将该缩印后面的元素整体向前移动)
* 3.维护数组中元素个数
* 3.判断当前数组的容量，若需缩荣，则缩容

伪代码:
```
ADD-INDEX(e,index):
     if(index < 0 || index > size)
         throw new ArrayIndexOutOfBoundsException("index out of bound")
     for(i = index; i < size - 1; i++)
         data[i] = data[i + 1] 
     size--
     if(size == data.length / 4)
         RESIZE(data.length / 2)
```
java代码实现:
```
public E remove(int index){
    if(index < 0 || index >= size){
        throw new ArrayIndexOutOfBoundsException("index out of bound");
    }
    E res = data[index];
    for(int i = index; i < size - 1; i++){
        data[i] =data[i+1];
    }
    data[size] = null;
    size --;
    if(size == data.length / 4){
        resize(data.length / 2);
    }
    return res;
}
```
删除元素示意图:
![image](https://github.com/FunCheney/data-structure/blob/master/src/main/java/com/fchen/datastructure/array/image/remove.gif "remove")

##### 2.3 数组中修改元素(替换某一索引的元素)
java代码实现:
```
public void set(E e,int index){
    if(index < 0 || index >= size){
        throw new ArrayIndexOutOfBoundsException();
    }
    data[index] = e;
}
```

##### 2.4 查找数组中的元素(获取某一索引位置的元素)
java代码实现:
```
 public E getIndex(int index){
    if(index < 0 || index >= size){
         throw new ArrayIndexOutOfBoundsException();
     }
     return data[index];
 }
``` 
 

