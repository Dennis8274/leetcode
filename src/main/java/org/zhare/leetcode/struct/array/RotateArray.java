package org.zhare.leetcode.struct.array;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/9
 */
public class RotateArray {
    /*
     * 189 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        rotate(values, 2);
        print(values);

    }

    private static void rotate2(int[] values, int n) {
        if (values == null || values.length < 1) return;

        int len = values.length;
        for (int i = 0; i < n; ++i) {
            int pivot = values[len - 1];
            for (int j = len - 1; j > 0; --j) {
                values[j] = values[j - 1];
            }
            values[0] = pivot;
        }
    }

    private static void rotate3(int[] values, int n) {
        n = n % values.length;

        reverse(values, 0, values.length - 1);
        reverse(values, 0, n - 1);
        reverse(values, n, values.length - 1);
    }

    private static void reverse(int[] values, int start, int end) {
        while (start < end) {
            int temp = values[start];
            values[start] = values[end];
            values[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotate(int[] values, int n) {
        int len = values.length;
        n = n % len;
        int count = 0;
        for (int i = 0; count < len; ++i) {
            int current = i;

            int soldier;
            int prev = values[current];
            do {
                soldier = prev;
                current = (current + n) % len;
                prev = values[current];
                values[current] = soldier;
                count++;
            } while (current != i);
        }
    }

    private static void print(int[] values) {
        System.out.println(Arrays.toString(values));
    }
}
