package org.zhare.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dennis
 * @since 2019/12/21
 */
public class One {
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
