package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/19
 */
public class TwentySix {

    /*
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */

    public static void main(String[] args) {
        int[] values = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(values);
        for (int i = 0; i < len; ++i) {
            System.out.print(values[i] + " ");
        }
    }

    // 时间复杂度 O(n) 空间复杂度 O(1)
    private static int removeDuplicates(int[] values) {
        if (values == null || values.length == 0) return 0;

        int cur = 0;
        for (int i = 1; i < values.length; ++i) {
            if (values[cur] != values[i]) {
                values[++cur] = values[i];
            }
        }

        return cur + 1;
    }

}
