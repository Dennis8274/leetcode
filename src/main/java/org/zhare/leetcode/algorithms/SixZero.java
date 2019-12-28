package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/24
 */
public class SixZero {

    /*
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 给定 n 和 k，返回第 k 个排列。
     */

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    private static String getPermutation(int n, int k) {
        StringBuilder buffer = new StringBuilder(n);
        int f = factorial(n);
        boolean[] visited = new boolean[n];
        for (int i = n; i > 0; --i) {
            f /= i;
            int offset = k % f;
            int base = k / f + (offset > 0 ? 1 : 0);
            k = offset == 0 ? f : offset;
            int appendDigit = appendDigit(base, visited);
            visited[appendDigit - 1] = true;
            buffer.append(appendDigit);
        }

        return buffer.toString();
    }

    private static int appendDigit(int base, boolean[] visited) {
        int i = 0;
        for (; i < visited.length && base > 0; ++i) {
            if (!visited[i]) --base;
        }
        return i;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }

        return result;
    }
}
