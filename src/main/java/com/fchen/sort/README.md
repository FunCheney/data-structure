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

<img src="/Users/wanba/Pictures/数据结构画图/数组/冒泡排序/gif.gif" alt="数组" style="zoom:100%;" />

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

<img src="/Users/wanba/Pictures/数据结构画图/数组/选择排序/gif.gif" alt="数组" style="zoom:100%;" />

##### 3.插入排序

&ensp;&ensp;插入排序，将新的数据与原理已经排好序的数据比较，在原先已经拍好序的数据找到合适的位置，放置新插入的数据。

&ensp;&ensp;插入排序当前索引左边的数据都是有序的，但最终的位置不确定。如果插入的元素较小，他们会向右移动。当索引到达数组的最右边时，数组就排好序了。

```java
public class InsertSort {

    public int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex > 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex +1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }
}
```

###### 图解

<img src="/Users/wanba/Pictures/数据结构画图/数组/插入排序/gif.gif" alt="数组" style="zoom:100%;" />

##### 4.希尔排序

&ensp;&ensp;希尔排序是一种基于插入排序的快速排序算法，插入排序的实现是交换数组中相邻元素的位置，因此元素只能一点一点地从数组的一端移动到另一端。如果数组中最小的元素是数组中的最后一个元素，那么这个元素要移动N-1次才能移动到合适的位置。

&ensp;&ensp;希尔排序为了加快速度简单的改进了插入排序，交换不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部有序的数组排序。

###### 思想

&ensp;&ensp;使数组中任意间隔为h的元素都是有序的。在排序时，如果h很大，就能够将元素移动到很远的地方，为实现更小的h创造方便。

```java
public class ShellSort{
    public static int[] sort(int[] arr){
        int n = arr.length;
        int h = 1;
        while (h < n / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            //将数组变为h有序
            for (int i = h; i < n; i++){
                for (int j = i; j >= h; j -= h){
                    if(arr[j] < arr[j -h]){
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
            h = h / 3;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,1,9,3,8};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}

```

<img src="/Users/wanba/Pictures/数据结构画图/数组/希尔排序/gif.gif" alt="数组" style="zoom:100%;" />

##### 5.归并排序

&ensp;&ensp;归并排序，就是将两个有序的数组合并成一个更大的有序数组。对一个数组进行排序，可先将该数组分成(递归)两半，直到不能分割。然后分别排序，最后在将结果归并起来。

&ensp;&ensp;实现归并的一种办法是将两个不同的有序数组归并到第三个数组中，创建一个适当大小的数组然后将两个输入数组中的元素一个个从小到大放入到数组中。但是，当用归并将一个大数组排序时，需要进行多次归并，如果在每次归并时都创建一个新数组来存储结果，会过多的消耗内存空间，可能会出问题。我们希望能有一种原地归并的的方法，这样就可以先将前半部分排序，再将后半部分排序，然后在数组中移动元素而不需要使用额外的空间。

```java
public class MergeSort {
   public static void main(String[] args) {
        int[] arr = {8,4,6,5,7,3,2,1};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int lo, int hi, int[] temp){
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        //数组的左半边排序
        sort(arr, lo, mid, temp);
        //数组的右半边排序
        sort(arr, mid + 1, hi, temp);
        merge(arr, lo, mid, hi, temp);
    }
    public static void merge(int[] arr, int lo, int mid, int hi, int[] temp){
        int i = lo,j = mid + 1;
        for (int k = lo; k <= hi; k++){
            temp[k] = arr[k];
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid )
                // 左半边用尽，取右半边元素
                arr[k] = temp[j++];
            else if(j > hi)
                // 右半边用尽，取左半边元素
                arr[k] = temp[i++];
            else if(temp[j] > temp[i])
                // 右半边当前的元素大于左半边当前的元素，取左半边的元素
                arr[k] = temp[i++];
            else
                //右半边当前的元素小于等于左半边当前的元素,取右半边的元素
                arr[k] = temp[j++];
        }
    }
}
```

###### 图解

<img src="/Users/wanba/Pictures/数据结构画图/数组/归并排序/gif.gif" alt="数组" style="zoom:100%;" />

#####6.快速排序

&ensp;&ensp;快速排序是一种分治的排序算法。它将一个数组分成两个子数组，将两部分独立地排序。在快速排序的时候，首先找到一个元素a[j]，使得a[lo]到a[j - 1]中所有的元素都不大于a[j]；使得a[j + 1]到a[hi]中所有的元素都不小于a[j]。确定a[j]的过程，将数组切分成两部分。在这两部分数组中递归的调用上述过程，来完成排序。

&ensp;&ensp;在上述切分数组的过程中，每切分一次，就能排定一个元素。如果左子数组和右子数组都是有序的，那么由左子数组和右子数组组成的数组也一定是有序的。

&ensp;&ensp;在获取切分元素的时候，先随意的取a[lo]作为切分元素，然后从左到右扫描数组直到找到一个大于等于它的元素，在从右到左找到一个小于等于它的元素。这两个元素显然是没有排定的，因此交换它们的位置。如此继续，直到本次循环结束，就可以保证左指针i的左侧元素都不大于切分元素，右指针j的右侧元素都不小于切分元素。当两个指针相遇时，只需要切分元素a[lo]和左子数组最右侧的元素(a[j])交换然后返回j即可。过程如下图：

<img src="/Users/wanba/Pictures/数据结构画图/数组/快速排序/quick_sort_01.jpg" alt="数组" style="zoom:80%;" />

```java
public class QuickSort{
    public static void main(String[] args) {
        int[] arr = {8,4,6,5,7,3,2,1};
        quickSort(arr,0,arr.length - 1);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    public static void  quickSort(int[] arr, int left, int right){
        if(right > left) {
            int j = partition(arr, left, right);
            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right){
        int i = left, j = right + 1;
        int num = arr[left];
        while (true){
            while (i < arr.length - 1 && arr[++i] <= num){
                if(left == right){
                    break;
                }
            }
            while (j > 0 && arr[--j] > num){
                if (j == left){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 将V = a[j]放入到正确的位置
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;
        // arr[lo...j-1] <= arr[j] <= arr[j+1...hi]
        return j;
    }
}
```

&ensp;&ensp;快速排序切分方法的内循环会用一个递增的索引将数组元素和一个定值比较。快速排序的最好情况是每次都正好能将数组对半分。

<img src="/Users/wanba/Pictures/数据结构画图/数组/快速排序/gif.gif" alt="数组" style="zoom:100%;" />







