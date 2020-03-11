package util.sort;

import com.sun.scenario.effect.Merge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public class MergeSort {

    // 禁止实例化
    private MergeSort() {
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;    // 这样可以有效避免整形溢出
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    // 要注意 aux 的下标映射
    static void merge(int[] arr, int l, int mid, int r) {
        // [l,r] -> [0, r-l]    mid -> mid-l
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 赋初始值 j-[0, mid-l]  k-[mid-l+1,r-l]
        int j = 0, k = mid - l + 1;
        for (int i = l; i <= r; i++) {
            if (j > mid - l) {
                System.arraycopy(aux, k, arr, i, r - l - k + 1);
                break;
            }
            if (k > r - l) {
                System.arraycopy(aux, j, arr, i, mid - l - j + 1);
                break;
            }
            if (aux[j] < aux[k]) {
                arr[i] = aux[j++];  // 不需要i++，因为for循环已经加了
            } else {
                arr[i] = aux[k++];
            }
        }
        // 释放辅助数组
        aux = null;
    }

    // 利用归并排序求逆序数 inverse number
    static long invCnt = 0;

    static void calcInverseCount(int[] arr) {
        int n = arr.length;
        calcInverseCount(arr, 0, n - 1);
    }

    static void calcInverseCount(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // int mid = l / 2 + r / 2;
        int mid = l + (r - l) / 2;    // 这样可以有效避免整形溢出
        calcInverseCount(arr, l, mid);
        calcInverseCount(arr, mid + 1, r);

        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge, 逆序数不需要增加
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid + 1]) {
            mergeCalc(arr, l, mid, r);
        }
    }

    static void mergeCalc(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);    // aux[0]<--> arr[l]
        // k[l, r]  i[l, mid] j[mid+1, r]
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
                // 逆序数增加, 例如：3 5 8 | 3 5 12
                invCnt += mid - i + 1;
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] arr = SortTestHelper.generateRandomArray(8000, 1, 20);
        //        SortTestHelper.printArray("before: ", arr);
        //        System.out.println(" ");
        //        calcInverseCount(arr);
        //        SortTestHelper.printArray("after: ", arr);
        //        System.out.println(" ");
        //        System.out.println("invCnt: " + invCnt);


        String sortClassName = "util.sort.MergeSort";
        // 通过sortClassName获得排序函数的Class对象
        Class sortClass = Class.forName(sortClassName);
        // 通过排序函数的Class对象获得排序方法
        Method sortMethod = sortClass.getMethod("mergeSort", int[].class);
        // 排序参数只有一个，是可比较数组arr
        Object[] params = new Object[]{arr};

        double startTime = System.nanoTime() / 1000000;
        // 调用排序函数
        sortMethod.invoke(null, params);
        long endTime = System.nanoTime() / 1000000;


        System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");


    }
}

