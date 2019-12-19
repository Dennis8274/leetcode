package org.zhare.leetcode.struct.sort.innersort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/15
 */
public class MergeSort {
    /*
    *
    * 归并排序
    * 稳定
    *
    * 时间复杂度：O(nlogn) 最好 最坏 平均
    * 空间复杂度：O(n)
    *
    * 与快排区别：由下而上，先处理子问题，再合并
    *
    * */

    public static void main(String[] args) {
        int[] values = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
    }

    private static void sort(int[] values, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        sort(values, l, m);
        sort(values, m + 1, r);
        merge(values, l, m, r);

    }

    private static void merge(int[] values, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= r) {
            if (values[i] <= values[j]) {
                temp[k++] = values[i++];
            } else {
                temp[k++] = values[j++];
            }
        }

        int start = i;
        int end = m;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = values[start++];
        }

        for (int n = 0; n < r - l + 1; ++n) {
            values[l + n] = temp[n];
        }


    }
}
