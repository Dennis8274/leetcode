package org.zhare.leetcode.algorithms.sort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/14
 */
public class InsertionSort {
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
