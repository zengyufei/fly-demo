package com.zyf.test.算法.快速排序;

public class 快排1 {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(arr, 0, arr.length - 1);
        for (int val : arr) {
            System.out.print(val + ", ");
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if (left > right) return;

        int key = arr[left];
        int i = left;
        int j = right;

        while (i != j) {
            while (arr[j] >= key && i < j) {
                j--;
            }
            while (arr[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
            }
        }

        arr[left] = arr[i];
        arr[i] = key;

        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }

}
