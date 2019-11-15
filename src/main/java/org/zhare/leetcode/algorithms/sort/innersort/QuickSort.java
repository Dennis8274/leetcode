package org.zhare.leetcode.algorithms.sort.innersort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/15
 */
public class QuickSort {
    /*
     * 快速排序
     *
     * 不稳定
     * 原地
     * 时间复杂度：O(nlog) 最好/平均：O(nlog) 最坏O(n^2)[进行n次分区]
     * 空间复杂度O(1)
     * */
    public static void main(String[] args) {
        int[] values = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
    }

    private static void sort(int[] values, int i, int j) {
        if (i >= j) return;
        int p = partition(values, i, j);
        sort(values, i, p - 1);
        sort(values, p + 1, j);
    }

    private static int partition(int[] values, int i, int j) {
        int pivot = values[j];
        int k = i;
        for (int n = i; n < j; ++n) {
            if (values[n] < pivot) {
                swap(values, n, k);
                k++;
            }
        }
        swap(values, j, k);
        return k;
    }


    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
