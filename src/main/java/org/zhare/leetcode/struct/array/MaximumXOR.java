package org.zhare.leetcode.struct.array;

import java.util.HashSet;
import java.util.Set;

/**
 * middle
 *
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/14
 */
public class MaximumXOR {
    /*
     * 421
     *
     * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 2^31 。
     * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。要求:O(n)
     *
     */

    public static void main(String[] args) {
        int[] values = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(values));
    }

    /*
     * 一个很重要的知识点: x^y = z 具有逆反性 即能推出 -> x^z = y
     *
     * 先确定高位，再确定地位。一位一位的确定数位的大小
     *
     * 时间复杂度：O(n)
     */
    private static int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0x0;
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);   // 前缀(高i位)的掩码

            Set<Integer> set = new HashSet<Integer>(nums.length);
            for (int num : nums) {
                set.add(mask & num);    // 保留前缀，从高位到低位
            }

            int temp = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    res = temp;
                    break;
                }
            }
        }

        return res;
    }
}
