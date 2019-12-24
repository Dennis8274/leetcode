package org.zhare.leetcode.algorithms;

import java.util.*;

/**
 * @author dennis
 * @since 2019/12/21
 */
public class OneEight {

    /*
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 答案中不可以包含重复的四元组。
     */

    public static void main(String[] args) {
        int[] values = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(values, target);
        System.out.println(Arrays.deepToString(result.toArray()));

    }

    // 时间复杂度 O(n^3)
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        HashMap<Integer, List<int[]>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                List<int[]> ints = cache.computeIfAbsent(nums[i] + nums[j], k -> new ArrayList<>());
                ints.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                List<int[]> col = cache.get(target - nums[i] - nums[j]);
                if (col == null) continue;
                for (int[] val : col) {
                    if (j >= val[0]) continue;  //  重叠 overlap
                    Integer[] arr = new Integer[]{nums[i], nums[j], nums[val[0]], nums[val[1]]};
                    result.add(Arrays.asList(arr));
                }
            }
        }

        return result;
    }
}
