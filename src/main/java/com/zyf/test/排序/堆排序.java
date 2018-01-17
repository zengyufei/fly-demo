package com.zyf.test.排序;

/**
 * 原理
 * 堆排序在 top K 问题中使用比较频繁。堆排序是采用二叉堆的数据结构来实现的，虽然实质上还是一维数组。二叉堆是一个近似完全二叉树。
 * 二叉堆具有以下性质：
 * 父节点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
 * 每个节点的左右子树都是一个二叉堆（都是最大堆或最小堆）。
 * 步骤：
 * 1、构造最大堆（Build_Max_Heap）：若数组下标范围为 0~n，考虑到单独一个元素是大根堆，则从下标 n/2 开始的元素均为大根堆。
 * 于是只要从 n/2-1 开始，向前依次构造大根堆，这样就能保证，构造到某个节点时，它的左右子树都已经是大根堆。
 * 2、堆排序（HeapSort）：由于堆是用数组模拟的。得到一个大根堆后，数组内部并不是有序的。因此需要将堆化数组有序化。
 * 思想是移除根节点，并做最大堆调整的递归运算。第一次将 heap[0] 与 heap[n-1] 交换，再对 heap[0...n-2] 做最大堆调整。
 * 第二次将 heap[0] 与 heap[n-2] 交换，再对 heap[0...n-3] 做最大堆调整。重复该操作直至 heap[0] 和 heap[1] 交换。
 * 由于每次都是将最大的数并入到后面的有序区间，故操作完后整个数组就是有序的了。
 * 3、最大堆调整（Max_Heapify）：该方法是提供给上述两个过程调用的。目的是将堆的末端子节点作调整，使得子节点永远小于父节点。
 * 性能
 * 时间复杂度为 $O(NlogN)$，空间复杂度为 $O(1)$，因为利用的排序空间仍然是初始的序列，并未开辟新空间。算法是不稳定的，与初始序列无关。
 * 使用场景
 * 想知道最大值或最小值时，比如优先级队列，作业调度等场景。
 */
public class 堆排序 {

    /*http://blog.csdn.net/zdp072/article/details/44227317*/
    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 堆排序
        heapSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     *  堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
    }

    /**
     *  构建堆的过程
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增 1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
    }

    // 获取到左孩子结点
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
