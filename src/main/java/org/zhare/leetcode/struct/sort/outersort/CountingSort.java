package org.zhare.leetcode.struct.sort.outersort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/16
 */
public class CountingSort {
    /*
     * 计数排序
     *
     * 线性排序 时间复杂度 O(n)
     *
     * 数据要求：数据范围小
     * 桶排序的一种特殊情况
     * */

    public static void main(String[] args) {
        int[] s = new int[]{2, 5, 5, 2, 1, 2, 3, 0};
        int[] result = sort(s, 5);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sort(int[] values, int maxVal) {
        int[] c = new int[maxVal + 1]; // inclusive 0

        // compute c
        for (int i = 0; i < values.length; ++i) {
            c[values[i]]++;
        }

        // compute count c
        for (int i = 1; i < c.length; ++i) {
            c[i] += c[i - 1];
        }

        int[] result = new int[values.length];
        // scan from end to start
        for (int i = values.length - 1; i >= 0; --i) {
            int value = values[i];
            result[c[value] - 1] = value;
            c[value]--;
        }
        return result;
    }
}
