package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/11/11
 */
public class HanoiTower {
    /* 汉诺塔 */

    public static void main(String[] args) {
        hanoi(3, 'a', 'b', 'c');
    }

    private static void hanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("[" + n + "] " + a + " --> " + c);
            return;
        }
        hanoi(n - 1, a, c, b);
        System.out.println("[" + n + "] " + a + " --> " + c);
        hanoi(n - 1, b, a, c);
    }
}
