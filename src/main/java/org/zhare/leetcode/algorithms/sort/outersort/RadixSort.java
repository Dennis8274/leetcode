package org.zhare.leetcode.algorithms.sort.outersort;

/**
 * @author dennis
 * @since 2019/11/16
 */
public class RadixSort {
    /*
     * 计数排序
     *
     * 线性排序
     * 数据要求: 数据不等长则需要补成等长的；可以分成独立的"位"来比较，并且"位"的范围不能太大
     * */

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 'c'}, {'c', 'b', 'c'}, {'b', 'c', 'a'}, {'b', 'c', 'b'}, {'c', 'a', 'b'}};
        char[][] result = sort(chars, 3);
        print(result);
    }

    private static char[][] sort(char[][] chars, int radixLen) {
        for (int i = radixLen - 1; i >= 0; --i) {
            chars = countingSort(chars, i);
        }

        return chars;
    }

    private static char[][] countingSort(char[][] chars, int n) {
        int[] c = new int[3];
        for (int i = 0; i < chars.length; ++i) {
            c[chars[i][n] - 'a']++;
        }

        for (int i = 1; i < c.length; ++i) {
            c[i] += c[i - 1];
        }

        char[][] result = new char[chars.length][3];
        for (int i = chars.length - 1; i >= 0; --i) {
            int index = (chars[i][n] - 'a');
            result[c[index] - 1] = chars[i];
            c[index]--;
        }

        return result;
    }

    private static void print(char[][] chars) {
        for (char[] ch : chars) {
            for (char c : ch) {
                System.out.print(c);
            }
            System.out.print(" ");
        }
    }
}