package org.zhare.leetcode.algorithms.sort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/14
 */
public class InsertionSort {
    /*
    *
    * 插入排序
    * 稳定
    *
   * 时间复杂度：O(n^2) 最好情况O(n)
    * 空间复杂度：O(1) 原地
    *
    * */

    public static void main(String[] args) {
        int[] values = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        sort(values);
        System.out.println(Arrays.toString(values));
    }

    private static void sort(int[] values) {
        for (int i = 1; i < values.length; ++i) {
            int value = values[i];
            for (int j = i - 1; j >= 0; --j) {
                if (values[j] <= value) {
                    values[j + 1] = value;
                    break;
                }
                values[j + 1] = values[j];
            }
        }
    }
}
