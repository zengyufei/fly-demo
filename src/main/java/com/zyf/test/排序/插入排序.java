package com.zyf.test.排序;

/**
 * 原理
 * 依次选择一个待排序的数据，插入到前边已排好序的序列中。
 * 性能
 * 时间复杂度为 $O(N^2)$，空间复杂度为 $O(1)$。算法是稳定的，比较次数和交换次数都与初始序列有关。
 * 优化
 * 直接插入排序每次往前插入时，是按顺序依次往前找，可在这里进行优化，往前找合适的插入位置时采用二分查找的方式，即折半插入。
 * 折半插入排序相对直接插入排序而言：平均性能更快，时间复杂度降至 $O(NlogN)$，排序是稳定的，但排序的比较次数与初始序列无关，
 * 总是需要 $foor(log(i))+1$ 次排序比较。
 */
public class 插入排序 {

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            out:
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else break out;
            }
        }
    }

    public static void insertBinarySort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int low = 0, high = i - 1, mid;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (temp < arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for (int j = i; j > low; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[low] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 9, 2, 6, 3};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("----------------------------------------------------");
        int[] arr2 = {65, 12, 89, 87, 23, 45, 64, 1, 0, 79, 34};
        insertBinarySort(arr2);
        for (int i : arr2) {
            System.out.println(i);
        }
    }

}
