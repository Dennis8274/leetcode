package org.zhare.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dennis
 * @since 2019/12/21
 */
public class One {
    /*
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */

    public static void main(String[] args) {
        int[] values = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(values, target);
        System.out.println(Arrays.toString(result));
    }

    /* 时间复杂度 O(n) 空间复杂度 O(n) */
    private static int[] twoSum(int[] values, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; ++i) {
            int minus = target - values[i];
            if (map.containsKey(minus)) {
                return new int[]{map.get(minus), i};
            }
            map.put(values[i], i);
        }
        throw new RuntimeException("No such two sum.");
    }
}
