package com.zyf.test.算法.快速排序;

/**
 * 使用三向切分优化快速排序 适用于待排序数组中存在许多重复元素的使用场景 1个方向用于记录比基准值小的元素 1个方向用于记录与基准值相同的元素
 * 1个方向用于记录比基准值大的元素 与普通快速排序主要区别在partition的划分
 */
public class 三向切分优化快速排序 {
    
    public static void sort(int[] a) {
        partition(a, 0, a.length - 1);
    }

    // 使用三向划分数组
    private static void partition(int[] a, int low, int high) {
        if (low >= high)
            return;
        int pivot = a[low];
        // l指向小于基准值的元素右边界，e指向等于基准值的元素右边界，h指向大于基准值的左边界
        int l = low, e = low + 1, h = high;
        while (e <= h) {
            if (a[e] < pivot) //a[e]小于基准值，交换a[l],a[e];l,e右移 
                swap(a, l++, e++);
            else if (a[e] > pivot) //a[e]大于基准值,交换a[h],a[e],h左移
                swap(a, e, h--);
            else //a[e]等于基准值,e右移
                e++;
        }
        partition(a, low, l - 1);
        partition(a, h + 1, high);
    }

    private static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // 测试函数
    public static void main(String[] args) {
        int[] a = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(a);
        print(a);
    }
}