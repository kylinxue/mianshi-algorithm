package util.sort;

import java.util.Random;

public class SortTestHelper {

    // 生成 n 个 [rangeL, rangeR] 的随机数
    //     public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
    //             assert rangeL <= rangeR : "rangeL <= rangeR";
    //                     int[] arr = new int[n];
    //                             // 通过随机种子生成不同的伪随机序列
    //                                     Random random = new Random(System.currentTimeMillis());
    //                                             for (int i = 0; i < n; i++) {
    //                                                         arr[i] = rangeL + random.nextInt(rangeR - rangeL + 1);
    //                                                                 }
    //
    //                                                                         return arr;
    //                                                                             }
    //
    //                                                                                 public static <T>  void printArray(T[] arr) {
    //                                                                                         for (T i : arr) {
    //                                                                                                     System.out.print( i + " ");
    //                                                                                                             }
    //                                                                                                                 }
    //
    //                                                                                                                     public static void printArray(int[] arr) {
    //                                                                                                                             for (int i : arr) {
    //                                                                                                                                         System.out.print( i + " ");
    //                                                                                                                                                 }
    //                                                                                                                                                     }
    //
    //                                                                                                                                                         public static void printArray(String message, int[] arr) {
    //                                                                                                                                                                 System.out.print(message);
    //                                                                                                                                                                         for (int i : arr) {
    //                                                                                                                                                                                     System.out.print( i + " ");
    //                                                                                                                                                                                             }
    //                                                                                                                                                                                                 }
    //
    //                                                                                                                                                                                                     public static void main(String[] args) {
    //                                                                                                                                                                                                             int[] arr = generateRandomArray(5,1,10);
    //                                                                                                                                                                                                                     printArray(arr);
    //
    //                                                                                                                                                                                                                         }
    //                                                                                                                                                                                                                         }
    //
