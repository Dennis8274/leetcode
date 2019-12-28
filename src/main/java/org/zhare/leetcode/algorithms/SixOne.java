package org.zhare.leetcode.algorithms;

import static org.zhare.leetcode.algorithms.ListNode.print;

/**
 * @author dennis
 * @since 2019/12/28
 */
public class SixOne {

    /*
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     */

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        print(rotateRight(head, k));
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }

        int r = len - k % len;
        node.next = head;

        for (int i = 0; i < r; ++i) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;

        return newHead;

    }
}
