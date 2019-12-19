package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/19
 */
public class TwentySeven {

    /*
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    public static void main(String[] args) {
        int[] values = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int len = removeElements(values, val);
        for (int i = 0; i < len; ++i) {
            System.out.print(values[i] + " ");
        }
    }

    private static int removeElements(int[] values, int val) {
        if (values == null || values.length == 0) return 0;

        int cur = 0;
        for (int i = 0; i < values.length; ++i) {
            if (values[i] != val) {
                values[cur++] = values[i];
            }
        }

        return cur;
    }
}
