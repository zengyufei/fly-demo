package com.zyf.test.排序;

/**
 * 原理
 * 俩俩比较相邻记录的排序码，若发生逆序，则交换；有俩种方式进行冒泡，一种是先把小的冒泡到前边去，另一种是把大的元素冒泡到后边。
 * 性能
 * 时间复杂度为 $O(N^2)$，空间复杂度为 $O(1)$。排序是稳定的，排序比较次数与初始序列无关，但交换次数与初始序列有关。
 * 优化
 * 若初始序列就是排序好的，对于冒泡排序仍然还要比较 $O(N^2)$ 次，但无交换次数。可根据这个进行优化，
 * 设置一个 flag，当在一趟序列中没有发生交换，则该序列已排序好，但优化后排序的时间复杂度没有发生量级的改变。
 */
public class 冒泡排序 {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 9, 2, 6, 3};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
