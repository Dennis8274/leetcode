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
        int[] valuesTheNext = new int[]{1, 2, 2, 2, 5, 5, 7, 9};
        System.out.println(binarySearchFirst(valuesTheNext, 5));
        System.out.println(binarySearchLast(valuesTheNext, 2));
        System.out.println(binarySearchFirstGreater(valuesTheNext, 4));
        System.out.println(binarySearchLastLess(valuesTheNext, 5));
    }

    // 查找最后一个小于等于给定值的元素
    private static int binarySearchLastLess(int[] values, int value) {
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (values[mid] > value) {
                right = mid - 1;
            } else {
                if (mid == values.length - 1 || values[mid + 1] > value) return mid;
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素
    private static int binarySearchFirstGreater(int[] values, int value) {
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (values[mid] < value) {
                left = mid + 1;
            } else {
                if (mid == 0 || values[mid - 1] < value) return mid;
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // 查找最后一个值等于给定值的元素
    private static int binarySearchLast(int[] values, int value) {
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (values[mid] < value) {
                left = mid + 1;
            } else if (values[mid] > value) {
                right = mid - 1;
            } else {
                if (mid == values.length - 1 || values[mid + 1] != value) return mid;
                else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    // 查找第一个值等于给定值的元素
    private static int binarySearchFirst(int[] values, int value) {
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (values[mid] < value) {
                left = mid + 1;
            } else if (values[mid] > value) {
                right = mid - 1;
            } else {
                if (mid == 0 || values[mid - 1] != value) return mid;
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
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
