package com.zyf.test.排序;


/**
 * 原理：
 * 分而治之思想：
 * Divide：找到基准元素 pivot，将数组 A[p..r] 划分为 A[p..pivotpos-1] 和 A[pivotpos+1...q]，左边的元素都比基准小，右边的元素都比基准大 ;
 * Conquer：对俩个划分的数组进行递归排序；
 * Combine：因为基准的作用，使得俩个子数组就地有序，无需合并操作。
 * 性能：
 * 快排的平均时间复杂度为 $O(NlogN）$，空间复杂度为 $O(logN)$，但最坏情况下，时间复杂度为 $O(N^2)$，空间复杂度为 $O(N)$；且排序是不稳定的，
 * 但每次都能确定一个元素所在序列中的最终位置，复杂度与初始序列有关。
 */
public class 快速排序 {

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortQuick(int[] quickArray) {
        int[] arr = quickArray;
        quickSort(0, arr.length - 1, arr);
    }

    public static void quickSort(int start, int end, int[] arr) {
        if (start < end) {
            int pivot = arr[start];
            int left = start;
            int right = end;
            while (left != right) {
                while (arr[right] >= pivot && left < right) right--;
                while (arr[left] <= pivot && left < right) left++;
                swap(left, right, arr);
            }
            arr[start] = arr[left];
            arr[left] = pivot;
            quickSort(start, left - 1, arr);
            quickSort(left + 1, end, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 9, 2, 6, 3};
        sortQuick(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
