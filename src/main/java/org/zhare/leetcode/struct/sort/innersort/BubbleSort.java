package org.zhare.leetcode.struct.sort.innersort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/14
 */
public class BubbleSort {
    /* 冒泡排序
    *
    * 时间复杂度：O(n^2) 最好情况O(n)
    * 空间复杂度：O(1)  原地排序
    * 稳定
    *  */
    public static void main(String[] args) {
        int[] values = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        sort(values);
        System.out.println(Arrays.toString(values));
    }

    private static void sort(int[] values) {
        for (int i = 0; i < values.length; ++i) {
            boolean hasSwap = false;
            for (int j = 0; j < values.length - i - 1; ++j) {
                if (values[j] > values[j + 1]) {
                    swap(j, j + 1, values);
                    hasSwap = true;
                }
            }
            if (!hasSwap) break;
        }
    }

    private static void swap(int i, int j, int[] values) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
