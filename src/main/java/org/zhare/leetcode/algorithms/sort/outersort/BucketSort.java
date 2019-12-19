package org.zhare.leetcode.algorithms.sort.outersort;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/16
 */
public class BucketSort {
    /*
     * 桶排序
     * 线性排序 时间复杂度：O(n)
     * 适用：1。能很容易划分到多个桶中，2。各个桶中的数据分布均匀
     * */

    public static void main(String[] args) {
        int[] values = new int[]{22, 5, 19, 50, 46, 32, 19, 50, 36, 29, 28, 39, 49, 29, 19, 4, 6, 1, 2};
        int[] result = sort(50, 5, 10, values);
        System.out.println(Arrays.toString(result));
    }

    private static void quickSort(int[] values, int i, int j) {
        if (i >= j) return;
        int pivot = partition(values, i, j);
        quickSort(values, i, pivot - 1);
        quickSort(values, pivot + 1, j);
    }

    private static int partition(int[] values, int i, int j) {
        int l = i;
        int pivot = values[j];
        for (int r = i; r < j; ++r) {
            if (values[r] < pivot) {
                swap(values, r, l);
                l++;
            }
        }
        swap(values, j, l);
        return l;
    }

    private static void swap(int[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    private static int[] sort(int maxVal, int n, int maxBucketSize, int[] values) {
        int[] indexes = new int[n];
        int[][] buckets = new int[n][];
        int range = maxVal / n + 1;
        for (int value : values) {
            int index = value / range;
            int[] bucket = buckets[index];
            if (bucket == null) {
                bucket = new int[maxBucketSize];
                buckets[index] = bucket;
            }
            bucket[indexes[index]++] = value;
        }

        int start = 0;
        for (int i = 0; i < buckets.length; ++i) {
            quickSort(buckets[i], 0, indexes[i] - 1);
            for (int j = 0; j < indexes[i]; ++j) {
                values[start++] = buckets[i][j];
            }
        }

        return values;
    }
}
