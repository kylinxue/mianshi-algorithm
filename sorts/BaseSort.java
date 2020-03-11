package util.sort;

public class BaseSort {

    //选择排序
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // [i, n) 找到 minValue 放入 arr[i]
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            swap(arr, i, minIdx);
        }
    }

    // 插入排序 -- 特别适合部分有序的数组
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // [0, i)是有序部分
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {  // 把当前插入的值提前拿出来，不需要全部交换了
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    // 性能不好，一般不使用，但代码比较简洁，所以学生的第一个排序算法
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 边界条件：j, j+1不能超过n-1, 取交集: j+1<n
            // [0, n-i) 找到最大的值放到 a[n-i-1]
            for (int j = 0; j + 1 < n - i; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray(10, 1, 20);
        selectionSort(arr);
        //insertionSort(arr);
        //bubbleSort(arr);
        SortTestHelper.printArray(arr);
    }
}

