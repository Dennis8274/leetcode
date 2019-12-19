package org.zhare.leetcode.struct.array;

import java.util.HashMap;
import java.util.Map;

/**
 * easy
 *
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/11
 */
public class TwoSum {
    /*
     * 1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     */
    public static void main(String[] args) {
        int[] values = {1, 3, 4, 8, 10, 2, 7};
        int target = 9;
        find(values, target);
    }

    private static void find(int[] values, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int s1 = -1;
        int s2 = -1;
        for (int i = 0; i < values.length; ++i) {
            int left = target - values[i];
            if (map.containsKey(left)) {
                s1 = i;
                s2 = map.get(left);
                break;
            }
            map.put(values[i], i);
        }

        System.out.println("two value index are: " + s1 + " " + s2);
    }

}
