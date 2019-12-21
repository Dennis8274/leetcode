package org.zhare.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/12/21
 */
public class OneSix {

    /*
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     */
    public static void main(String[] args) {
        int[] values = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(closestThreeSum(values, target));
    }

    private static int closestThreeSum(int[] values, int target) {
        if (values == null || values.length < 3) return 0;

        Arrays.sort(values);

        int closet = -1;
        int curGap = Integer.MAX_VALUE;
        for (int i = 0; i < values.length - 2; ++i) {
            int left = i + 1;
            int right = values.length - 1;
            while (left < right) {
                int sum = values[i] + values[left] + values[right];
                int g = Math.abs(target - sum);
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else return target;
                if (curGap > g) {
                    curGap = g;
                    closet = sum;
                }
            }
        }

        return closet;
    }
}
