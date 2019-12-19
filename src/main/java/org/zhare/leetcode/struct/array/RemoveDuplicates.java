package org.zhare.leetcode.struct.array;

/**
 * easy
 *
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/13
 */
public class RemoveDuplicates {
    /*
     * 移除有序数组中重复的项，如：
     * [0,0,1,1,1,2,2,3,3,4] -> [0,1,2,3,4]
     */
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(nums);
    }

    private static void removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 1) return;

        int index = 0;
        int in = -1;
        while (index < len) {
            int cur = nums[index];
            while (++index < len && cur == nums[index]) ;
            nums[++in] = cur;
        }
        print(in, nums);
    }

    private static void print(int n, int[] nums) {
        for (int i = 0; i <= n; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}
