package org.zhare.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dennis
 * @since 2019/12/21
 */
public class OneTwoEight {

    /*
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     */

    public static void main(String[] args) {
        int[] values = new int[]{100, 6, 300, 4, 200, 1, 3, 2, 5};
        System.out.println(longestConsecutive(values));
    }

    private static int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {   //  官方答案果然优雅很多
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    private static int longestConsecutive(int[] values) {
        if (values == null) return 0;
        if (values.length <= 1) return values.length;

        HashSet<Integer> set = new HashSet<>();
        for (int i : values) {
            set.add(i);
        }

        int longestStreak = Integer.MIN_VALUE;
        for (int value : values) {
            int currentStreak = 1;
            for (int j = value - 1; set.contains(j); --j) {
                set.remove(j);
                currentStreak++;
            }
            for (int j = value + 1; set.contains(j); ++j) {
                set.remove(j);
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
