### 排序

&ensp;&ensp;在之前的数组学习中，数组只是用来存储数据的一种结构。而对数据的用途大多的时候实在这一结构中按照需要找出其中的数据。对数据进行排序，可能是检索的第一步。正如，之前提到的二分查找一样。在**LeetCode**的习题中，有一大部分的习题是基于**有序数组**来设计的。这就使得数据的处理简单了许多，因此，来学习一下如何让数组中的元素有序。

&ensp;&ensp;排序的目的：就是将所有元素的主键按照某种方式排列。

&ensp;&ensp;排序是非常重要而且可能非常的耗时，在计算机领域有太多的大牛研究，并有许多成熟的方法，下面将依次来了解学习这些方法。



#### 简单排序

#####1.冒泡排序

&ensp;&ensp;冒泡排序是最简单，也是最暴力的一种排序。

######原理：

&ensp;&ensp;从数组中的一个元素开始，依次往后，与其后面的元素逐个比较，将较大的元素向后移动。每循环一次，就将本次循环最大的元素，放到本次循环的最后。

###### 代码：

```java
public class BubbleSort {
    public int[] sort(int[] arr){
        //用来交换数据
        int temp = 0;
        boolean flag = false;
        for(int j = 0; j < arr.length - 1; j++){
            for(int i = 0; i < arr.length - 1 - j; i++){
                if(arr[i] > arr[i + 1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if (!flag){
              //没有交换数据，说明已经排好序，退出
                break;
            }else {
                flag = false;
            }
        }
        return arr;
    }
}
```



###### 图解：



##### 2.选择排序

&ensp;&ensp;选择排序是简单排序的算法中的一种，它在不断地选择剩余元素中最小元素。

######原理：

&ensp;&ensp;首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。然后，在剩下的元素中zhaodao最小的元素，将它与数组的第二元素交换位置。如此循环往复，直到将整个数组排序。

######代码：

```java
public class SelectSort {

    public int[] sort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            //用来表示当前最小值所在的索引
            int minIndex = i;
            //最小的元素在外层循环的位置
            int minNum = arr[i];
            for(int j = i + 1; j < arr.length - 1; j++){
                //内存循环判断有没有比假定最小元素还要小的元素
                if(minNum > arr[j]){
                    //重新赋值最小元素
                    minNum = arr[j];
                    //重新赋值最小元素所在位置
                    minIndex = j;
                }
            }
            if(minIndex != i){
                //有比假定最小值还小的元素，交换位置
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }
        }
        return arr;
    }
}
```

###### 图解：



######分析：



##### 3.插入排序

