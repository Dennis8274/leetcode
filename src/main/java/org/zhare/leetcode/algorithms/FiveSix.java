package org.zhare.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author dennis
 * @since 2019/12/30
 */
public class FiveSix {
    /*
     * 给出一个区间的集合，请合并所有重叠的区间。
     */

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = mergeIntervals(array);
        System.out.println(Arrays.deepToString(res));
    }

    private static int[][] mergeIntervals(int[][] array) {
        if (array == null || array.length <= 1) return array;

        List<Interval> res = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        for (int[] ints : array) {
            intervals.add(new Interval(ints[0], ints[1]));
        }
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);

        int i = 0;
        int[][] to = new int[res.size()][2];
        for (Interval interval : res) {
            to[i++] = new int[]{interval.start, interval.end};
        }
        return to;

    }

    static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
