package org.zhare.leetcode.struct.sort.innersort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/14
 */
public class SelectionSort {
    /*
     * 选择排序
     *
     * 不稳定
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     *
     * */

    public static void main(String[] args) {
        int[] values = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        sort(values);
        System.out.println(Arrays.toString(values));
    }

    private static void sort(int[] values) {
        for (int i = 0; i < values.length; ++i) {
            int min = i;
            for (int j = i; j < values.length; ++j) {
                if (values[min] > values[j]) {
                    min = j;
                }
            }
            swap(i, min, values);
        }
    }

    private static void swap(int i, int j, int[] values) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
