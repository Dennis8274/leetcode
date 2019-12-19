package org.zhare.leetcode.struct.array;

/**
 * hard
 *
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/11
 */
public class MediumOfTwoSortedArrays {
    /*
     * 4
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8};
        System.out.println(medium(nums1, nums2));

    }

    /*
     * 其实只需要遍历(m+n)/2+1个元素就能找到中位数
     *
     * 如果将两个数组合并，则：
     * 如果(m+n) 为奇数，中位数下标为 (m+n)/2+1
     * 如果是偶数，为 (m+n)/2 和 (m+n)/2+1
     *
     * 复杂度 O(m+n)
     */
    private static int medium(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int len = m + n;

        int first = 0;
        int second = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i <= len / 2; ++i) {
            left = right;
            if (first < m && (second >= n || nums1[first] < nums2[second])) {
                right = nums1[first++];
            } else {
                left = nums2[second++];
            }
        }

        if ((len & 1) == 0) {
            return (left + right) / 2;
        }

        return right;
    }

    /*
     * 可以将问题简化成寻找第k小的数
     * 一、当 (m+n) 为奇数时：
     * 找到第 (m+n+1)/2 小的数即为中位数
     *
     * 二、当 (m+n) 为偶数时：
     * 找到 第 (m+n)/2 小的数min1 和第 (m+n)/2 + 1 小的数min2 ，中位数为 (min1+min2)/2
     *
     * 两个数组分别取下标为 (k/2)  的元素比较
     * 谁小谁就往后移w位(其中 w = min(k/2, arrSize - start + 1)，arrSize-数组大小，start当前数组的位置)，迭代下一次比较，同时需要将 k-=w
     *
     */
    private static int medium2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;

        return (doMedium2(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left)
                + doMedium2(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) / 2;
    }

    // tips: 1. 当一个数组的剩余大小已经大于0且小于 k/2 的情况 2.始终保持参数中第一个数组是长度最小的 3. 一个数组剩余长度等于0的情况，移动位数位 min(k/2,len1)
    private static int doMedium2(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int size1 = end1 - start1 + 1;
        int size2 = end2 - start2 + 1;

        if (size1 > size2) return doMedium2(nums2, start2, end2, nums1, start1, end1, k);

        if (size1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int w = Math.min(k / 2, size1);
        if (nums1[start1 + w - 1] < nums2[start2 + w - 1]) {
            return doMedium2(nums1, start1 + w, end1, nums2, start2, end2, k - w);
        } else {
            return doMedium2(nums1, start1, end1, nums2, start2 + w, end2, k - w);
        }
    }

    /*
     * 利用中位数左右两边的元素个数相同的特性
     */
    private static int medium3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return medium3(nums2, nums1);

        int k = (len1 + len2 + 1) / 2;

        int left = 0;
        int right = len1 - 1;
        while (left < right) {
            int m1 = left + ((right - left) >>> 1);
            int m2 = k - m1 - 2;
            if (nums1[m1] < nums2[m2]) {
                left = m1 + 1;
            } else {
                right = m1;
            }
        }

        int m2 = k - left - 2;
        int c1 = Math.max(left <= 0 ? Integer.MIN_VALUE : nums1[left]
                , m2 <= 0 ? Integer.MIN_VALUE : nums2[m2]);
        if (((len1 + len2) & 0x1) == 1) {
            return c1;
        }

        int c2 = Math.min(left >= len1 - 1 ? Integer.MAX_VALUE : nums1[left + 1]
                , m2 >= len2 - 1 ? Integer.MAX_VALUE : nums2[m2 + 1]);

        return (c1 + c2) / 2;
    }
}
