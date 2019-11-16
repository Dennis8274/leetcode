package org.zhare.leetcode.algorithms.others;

/**
 * @author dennis
 * @since 2019/11/16
 */
public class BinarySearch {
    /*
     * 二分查找
     *
     * 时间复杂度：O(logn)
     * 适用条件：数据量太大太小均不适合，依赖数据有序，并且市数组存储
     * */

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(values, 4));
        System.out.println(binarySearchRecursive(values, 3));
    }

    private static int binarySearch(int[] values, int value) {
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (values[mid] == value) return mid;
            else if (values[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] values, int n) {
        return search(values, n, 0, values.length - 1);
    }

    private static int search(int[] values, int value, int left, int right) {
        if (left > right) return -1;
        int mid = left + ((right - left) >>> 1);
        if (values[mid] == value) {
            return mid;
        } else if (values[mid] < value) {
            return search(values, value, mid + 1, right);
        } else {
            return search(values, value, left, mid - 1);
        }

    }
}
