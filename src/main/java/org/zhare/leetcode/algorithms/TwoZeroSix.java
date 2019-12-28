package org.zhare.leetcode.algorithms;

import static org.zhare.leetcode.algorithms.ListNode.build;
import static org.zhare.leetcode.algorithms.ListNode.print;

/**
 * @author dennis
 * @since 2019/12/28
 */
public class TwoZeroSix {
    /*
     * 反转一个单链表。
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode root = build(nums);
        print(root);
        print(root = reverse(root));
        print(recursiveReverse(root));
    }

    private static ListNode reverse(ListNode root) {
        if (root == null) return null;
        ListNode pre = null;
        ListNode cur = root;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    private static ListNode recursiveReverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode root = recursiveReverse(node.next);
        ListNode next = node.next;
        next.next = node;
        node.next = null;

        return root;
    }

}
