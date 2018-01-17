package com.zyf.test.排序;

/**
 * 原理
 * 插入排序的改进版，是基于插入排序的以下俩点性质而提出的改进方法：
 * 插入排序对几乎已排好序的数据操作时，效率很高，可以达到线性排序的效率。
 * 但插入排序在每次往前插入时只能将数据移动一位，效率比较低。
 * 所以希尔排序的思想是：
 * 先是取一个合适的 gap<n 作为间隔，将全部元素分为 gap 个子序列，所有距离为 gap 的元素放入同一个子序列，再对每个子序列进行直接插入排序；
 * 缩小间隔 gap，例如去 gap=ceil(gap/2)，重复上述子序列划分和排序
 * 直到，最后 gap=1 时，将所有元素放在同一个序列中进行插入排序为止。
 *  性能
 * 开始时，gap 取值较大，子序列中的元素较少，排序速度快，克服了直接插入排序的缺点；其次，gap 值逐渐变小后，
 * 虽然子序列的元素逐渐变多，但大多元素已基本有序，所以继承了直接插入排序的优点，能以近线性的速度排好序。
 */
public class 希尔排序 {

    public static void shellSort(int[] arr) {
        int gap = Math.round(arr.length / 2);
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    if (arr[j] > arr[j - gap]) {
                        int temp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && arr[k] > temp) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i = i + gap) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 9, 2, 6, 3};
        shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------");
        int[] arr2 = {65, 12, 89, 87, 23, 45, 64, 1, 0, 79, 34};
        shellSort2(arr2);
        for (int i : arr2) {
            System.out.println(i);
        }
    }
}
