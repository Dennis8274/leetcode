package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/28
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode build(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        ListNode root = new ListNode(nums[0]);
        ListNode node = root;
        for (int i = 1; i < nums.length; ++i) {
            ListNode next = new ListNode(nums[i]);
            node.next = next;
            node = next;
        }

        return root;
    }

    static void print(ListNode root) {
        ListNode cur = root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
