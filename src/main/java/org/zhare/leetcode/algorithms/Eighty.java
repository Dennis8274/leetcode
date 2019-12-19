package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/19
 */
public class Eighty {

    /*
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */

    public static void main(String[] args) {
        int[] values = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int[] values = new int[]{0, 1, 2, 3, 4, 5};
        int len = another(values);
        for (int i = 0; i < len; ++i) {
            System.out.print(values[i] + " ");
        }
    }

    /* 同下 */
    private static int another(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int index = 3;
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] != nums[index - 3])
                nums[index++] = nums[i];
        }

        return index;
    }

    /* 时间复杂度O(n) 空间复杂度O(1) */
    private static int removeDuplicates2(int[] values) {
        if (values == null) return 0;
        if (values.length <= 2) return values.length;

        int cur = 0;
        int counts = 1;
        for (int i = 1; i < values.length; ++i) {
            if (values[cur] != values[i]) {
                values[++cur] = values[i];
                counts = 1;
                continue;
            }
            if (counts < 2) {
                values[++cur] = values[i];
            }
            ++counts;
        }

        return cur + 1;
    }
}
