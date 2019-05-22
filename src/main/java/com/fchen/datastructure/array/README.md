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
##### 1.2 数组的扩容
&ensp;&ensp;当数组中的元素超过数组的容量时，动态的修改数组的容量。(1)新建一个临时数组容量变为原来的3/2倍；(2)将原数组中的元素复制到临时数组中;
(3)将临时数组指向原来的数组。

伪代码：
```
RESIZE(data, size, length)
    E[] newData =  new E[length]
    for(int i = 0; i < size; i++){
        newData[i] = data[i]
    }
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

##### 1.3 数组的缩容
 

#### 2 数组的操作:
##### 2.1 数组中添加元素:

##### 2.2 数组中删除元素:

##### 2.3 数组中修改元素
 

