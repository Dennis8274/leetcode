package org.zhare.leetcode.algorithms;

import java.util.Stack;

/**
 * @author dennis
 * @since 2019/11/12
 */
public class TrapRainWater {
    /*
     * 42 接雨水
     *
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * */
    public static void main(String[] args) {
        int[] buckets = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap4(buckets));
    }

    // 暴力 找到当前位置左右两边最高的"尖",两"尖"中最小的"尖"决定集水量
    private static int trap(int[] buckets) {
        int len = buckets.length;
        int ans = 0;
        for (int i = 1; i < len - 1; ++i) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; --j) {
                maxLeft = Math.max(maxLeft, buckets[j]);
            }
            for (int j = i; j < len; ++j) {
                maxRight = Math.max(maxRight, buckets[j]);
            }
            ans += Math.min(maxLeft, maxRight) - buckets[i];
        }
        return ans;
    }

    // 动态编程
    private static int trap2(int[] buckets) {
        int ans = 0;
        int len = buckets.length;
        int[] maxLefts = new int[len];
        int[] maxRights = new int[len];
        maxLefts[0] = buckets[0];
        maxRights[len - 1] = buckets[len - 1];
        for (int i = 1; i < len - 1; ++i) {
            maxLefts[i] = Math.max(buckets[i], maxLefts[i - 1]);
        }
        for (int i = len - 2; i > 0; --i) {
            maxRights[i] = Math.max(buckets[i], maxRights[i + 1]);
        }
        for (int i = 1; i < len - 1; ++i) {
            ans += Math.min(maxLefts[i], maxRights[i]) - buckets[i];
        }
        return ans;
    }

    // 栈 两个"尖"，才能集水
    private static int trap3(int[] buckets) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int current = 0; current < buckets.length; ) {
            while (!stack.isEmpty() && buckets[current] > buckets[stack.peek()]) {
                int last = stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(buckets[current], buckets[stack.peek()]) - buckets[last];
                ans += distance * boundedHeight;
            }
            stack.push(current++);
        }
        return ans;
    }

    // 双指针 集水量高度由最矮的那边决定
    private static int trap4(int[] buckets) {
        int ans = 0;
        int left = 0;
        int right = buckets.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while (left < right) {
            if (buckets[left] < buckets[right]) {
                if (buckets[left] <= maxLeft) {
                    ans += maxLeft - buckets[left];
                } else {
                    maxLeft = buckets[left];
                }
                left++;
            } else {
                if (buckets[right] <= maxRight) {
                    ans += maxRight - buckets[right];
                } else {
                    maxRight = buckets[right];
                }
                right--;
            }
        }
        return ans;
    }
}
