package org.zhare.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/11
 */
public class FullPermutations {
    /*
     * 全排列
     * 如 [1,2,3]全排列为
     * 1 2 3
     * 2 1 3
     * 1 3 2
     * 3 1 2
     * 3 2 1
     * 2 3 1
     *
     * 递归，固定最后一位，就变成了[n-1]的全排列问题了。
     * 时间复杂度为指数级别(递归树的方式求时间复杂度)
     *
     * */

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        permutation(values,values.length);
    }

    private static void permutation(int[] values, int k) {
        // 退出条件
        if (k == 1) {
            System.out.println(Arrays.toString(values));
        }

        for (int i = 0; i < k; ++i) {
            int tmp = values[i];
            values[i] = values[k - 1];
            values[k - 1] = tmp;

            permutation(values, k - 1);

            tmp = values[i];
            values[i] = values[k - 1];
            values[k - 1] = tmp;
        }

    }
}
