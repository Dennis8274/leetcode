package org.zhare.leetcode.algorithms;

import java.util.*;

/**
 * @author dennis
 * @since 2019/12/21
 */
public class OneFive {
    /*
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     */

    public static void main(String[] args) {
        int[] values = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(values);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    private static List<List<Integer>> threeSum(int[] values) {
        List<List<Integer>> result = new ArrayList<>();
        if (values.length < 3) return result;
        Arrays.sort(values);
        for (int i = 0; i < values.length - 2; ++i) {
            if (values[i] > 0) break;
            if (i > 0 && values[i] == values[i - 1]) continue;

            int left = i + 1;
            int right = values.length - 1;
            while (left < right) {
                int sum = values[i] + values[left] + values[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(values[i], values[left], values[right]));
                    left++;
                    right--;
                    while (values[left] == values[left - 1] && left < right) left++;
                    while (values[right] == values[right + 1] && left < right) right--;
                }
            }
        }

        return result;
    }
}
