package util.sort;

import util.sort.SortTestHelper;

import java.util.Arrays;
import java.util.Random;

class QuikSort {

    public static void quikSort(int[] arr) {
        _quikSort(arr, 0, arr.length-1);
    }

    static void _quikSort(int[] arr, int l, int r) {
        if( l >= r) return;

        int pivotIdx = partition_1ways(arr, l, r);
        _quikSort(arr, l, pivotIdx-1);
        _quikSort(arr, pivotIdx+1, r);
    }

    static int partition_1ways(int[] arr, int l, int r) {
        assert l <= r : "l <= r";
        swap(arr, l, l+new Random().nextInt(r-l+1));  // pivot放置于l位置
        int v = arr[l];
        int j = l;  // 标记 < pivot 的最后一个, 注意j的初始位置
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, ++j, i);  // 将j增1, 并交换位置, 表明 <pivot 范围变大
            }
        }

        swap(arr, l, j);   // 将pivot的值放到最后一个 <pivot 的位置

        return j;
    }

    public static void quickSort_2ways(int[] arr) {
        _quickSort_2ways(arr, 0, arr.length - 1);
    }

    static void _quickSort_2ways(int[] arr, int l, int r) {
        if (l >= r) return;

        int pivotIdx = partition_2ways(arr, l, r);
        _quickSort_2ways(arr, l, pivotIdx - 1);
        _quickSort_2ways(arr, pivotIdx + 1, r);
    }

    //    等于 pivot
    //    的值 会被分散到
    //    pivot 的两边
    static int partition_2ways(int[] arr, int l, int r) {
        assert l <= r : "l <= r";

        swap(arr, l, l + new Random().nextInt(r - l + 1));  // pivot放置于l位置
        int v = arr[l];   // v = pivot

        // arr[l+1...i) <=pivot; arr(j...r] >=pivot
        // [l+1, r] 是操作空间
        int i = l + 1;
        int j = r;
        while (true) {
            while (arr[i] < v && i <= r) i++;   // i的值为 <pivot 的下一个值 >pivot
            while (arr[j] > v && j >= l + 1) j--;   // j的值为 >pivot 的上一个值 <pivot
            if (i > j) break;  // 退出循环之前的状态：j是小于pivot的最后一个元素
            swap(arr, i, j);
            i++;
            j--;    // 交换完后记得加1，下次循环直接使用还没有判断的下标
        }

        swap(arr, l, j);
        return j;
    }


    // 优化重复值
    public static void quikSork_3ways(int[] arr, int l, int r) {

        if (l >= r) return;

        swap(arr, l, l + new Random().nextInt(r - l + 1));
        int v = arr[l];

        // 最终 arr[l...lt]<v   arr[gt...r]>v   arr[lt+1, gt-1]==v
        // 初始时 lt 和 gt 是空集
        int lt = l;  // l位置的数据可以被覆盖
        int gt = r + 1;
        int i = l + 1;
        //for(int i=l+1; i<=r; i++){  // 扫描多了
        while (i < gt) {
            if (arr[i] < v) {  // 加入到<v
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i] > v) {
                swap(arr, gt - 1, i);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, l, lt);
        lt--;    // 原lt位置已经变为了 pivot 的索引

        quikSork_3ways(arr, l, lt);
        quikSork_3ways(arr, gt, r);
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // 查找第N小的数
    static int findNth(int[] arr, int left, int right, int N) {
        assert left < right;
        int len = right - left + 1;
        assert len < N : "n should be less than arr's length";

        int pivotIdx = left + new Random().nextInt(right - left + 1);
        int v = arr[pivotIdx];

        arr[pivotIdx] = arr[left];
        arr[left] = v;
        // [left, lt] < v    [gt, right] > v
        int i = left + 1;
        int lt = left;
        int gt = right + 1;

        // i [left+1, gt)
        while (i < gt) {
            if (arr[i] < v) {
                lt++;
                swap(arr, i, lt);  // i前面间断的情况需要交换
                i++;
            } else if (arr[i] > v) {
                gt--;
                swap(arr, i, gt);
            } else i++;
        }

        swap(arr, left, lt);
        pivotIdx = lt--;    // pivotIdx变为lt, lt向前移动一位

        // 根据 lt, gt 和 left+N-1 的关系
        if (lt < left + N - 1 && left + N - 1 < gt) {
            return arr[left + N - 1];
        } else if (lt > left + N - 1) {
            return findNth(arr, left, lt, N);
        } else {
            return findNth(arr, gt, right, N - (gt - left));
        }
    }


    public static void main(String[] args) {
        int[] arr = {43, 2, 41, 33, 36, 25, 24}; //SortTestHelper.generateRandomArray(7, 1, 50);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.printArray("排序前： ", arr);
        System.out.println(" ");
        // swap(arr, 1, 2);
        // quikSork_3ways(arr, 0, arr.length-1);
        quikSort(arr1);
        // quickSort_2ways(arr);
        // partition_2ways(arr, 0, arr.length-1);
        SortTestHelper.printArray("排序后：", arr1);
        System.out.println(" ");
        int n = findNth(arr, 0, arr.length - 1, 3);
        System.out.println("3th: " + n);
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  }
