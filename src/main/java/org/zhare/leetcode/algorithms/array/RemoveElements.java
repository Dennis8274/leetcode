package org.zhare.leetcode.algorithms.array;

/**
 * easy
 *
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/15
 */
public class RemoveElements {
    /*
     * 27
     *
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2, 2};
        System.out.println(removeElement(nums, 2));
    }

    /*
     * 移动元素的个数可能会很多，显得多余
     */
    private static int removeElements(int[] elements, int val) {
        int len = elements.length;

        int index = 0;
        int cur = index;
        while (index < len) {
            while (index < len && elements[index++] == val) ;

            if (elements[index - 1] != val)
                elements[cur++] = elements[index - 1];
        }
        return cur;
    }

    /*
     * 如果==val,通过和末尾元素交换（增加一个哨兵位）
     */
    private static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
