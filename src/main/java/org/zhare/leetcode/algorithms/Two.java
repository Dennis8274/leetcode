package org.zhare.leetcode.algorithms;

import static org.zhare.leetcode.algorithms.ListNode.print;

/**
 * @author dennis
 * @since 2019/12/28
 */
public class Two {
    /*
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{1, 8});
        ListNode l2 = ListNode.build(new int[]{0});
        print(addTwoNumbers(l1, l2));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int r = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            dummy.next = new ListNode((r + sum) % 10);
            r = (r + sum) / 10;
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }
        while (l1 != null) {
            int sum = l1.val + r;
            dummy.next = new ListNode(sum % 10);
            r = (l1.val + r) / 10;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + r;
            dummy.next = new ListNode(sum % 10);
            r = (l2.val + r) / 10;
            dummy = dummy.next;
            l2 = l2.next;
        }
        while (r > 0) {
            dummy.next = new ListNode(r % 10);
            r = r / 10;
        }
        return head.next;
    }
}
