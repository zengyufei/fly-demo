/**
 * Copyright (C): 恒大集团©版权所有 Evergrande Group
 * FileName: 归并排序
 * Author:   zengyufei
 * Date:     2018/01/17
 * Description: TODO
 */
package com.zyf.test.排序;

/**
 * 原理
 * 归并排序是采用分治法的一个非常典型的应用。归并排序的思想就是先递归分解数组，再合并数组。
 * 先考虑合并两个有序数组，基本思路是比较两个数组的最前面的数，谁小就先取谁，取了后相应的指针就往后移一位。
 * 然后再比较，直至一个数组为空，最后把另一个数组的剩余部分复制过来即可。
 * 再考虑递归分解，基本思路是将数组分解成 left 和 right，如果这两个数组内部数据是有序的，那么就可以用上面合并数组的方法将这两个数组合并排序。
 * 如何让这两个数组内部是有序的？可以再二分，直至分解出的小组只含有一个元素时为止，此时认为该小组内部已有序。然后合并排序相邻二个小组即可。
 * 性能
 * 时间复杂度总是为 $O(NlogN)$，空间复杂度也总为为 4O(N)$，算法与初始序列无关，排序是稳定的。
 */
public class 归并排序 {

    public static void mergeSort(int[] arr) {
        mergeSortDiv(arr, 0, arr.length - 1);
    }

    public static int[] mergeSortDiv(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSortDiv(arr, low, mid);
            // 右边
            mergeSortDiv(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }
        return arr;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 9, 2, 6, 3};
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
