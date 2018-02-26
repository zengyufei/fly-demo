package com.zyf.test.算法.快速排序;

import java.util.ArrayList;
import java.util.List;

public class 快排2 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        Integer[] newArr = sort(arr);
        for (Integer val : newArr) {
            System.out.print(val + ", ");
        }
    }

    private static Integer[] sort(Integer[] arr) {
        if (arr.length <= 1) return arr;

        List<Integer> left = new ArrayList<>(arr.length);
        List<Integer> right = new ArrayList<>(arr.length);
        int key = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < key) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }

        Integer[] leftArr = listToArray(left);
        Integer[] rightArr = listToArray(right);

        Integer[] arr2 = sort(rightArr);
        Integer[] arr1 = sort(leftArr);
        return 合并(arr1, key, arr2);
    }

    private static Integer[] 合并(Integer[] arr1, Integer key, Integer[] arr2) {
        int newLen = arr1.length + arr2.length + 1; // key 也需要额外的 1 个位置
        Integer[] newArr = new Integer[newLen];
        System.arraycopy(arr1, 0, newArr, 0, arr1.length);
        newArr[arr1.length] = key;
        System.arraycopy(arr2, 0, newArr, arr1.length + 1, arr2.length);
        return newArr;
    }

    /**
     * list 转 数组
     */
    private static Integer[] listToArray(List<Integer> list) {
        Integer[] leftArrTemp = new Integer[list.size()];
        return list.toArray(leftArrTemp);
    }

}
