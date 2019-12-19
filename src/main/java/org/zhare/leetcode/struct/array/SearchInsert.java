package org.zhare.leetcode.struct.array;

/**
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/15
 */
public class SearchInsert {
    /*
     * 35
     *
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 6, 6, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    private static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else right = mid - 1;
            } else {
                if (nums[mid + 1] >= target) return mid + 1;
                else left = mid + 1;
            }
        }

        if (nums[left] >= target) return left;
        else return left + 1;
    }
}
