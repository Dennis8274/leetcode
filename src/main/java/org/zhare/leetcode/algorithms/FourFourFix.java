package org.zhare.leetcode.algorithms;

import java.util.Stack;

import static org.zhare.leetcode.algorithms.ListNode.print;

/**
 * @author dennis
 * @since 2019/12/28
 */
public class FourFourFix {
    /*
     * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 进阶:
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     */

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.build(new int[]{5, 6, 4});

        print(addTwoNumbersAdvanced(l1, l2));
    }

    private static ListNode addTwoNumbersAdvanced(ListNode l1, ListNode l2) {
        final Stack<Integer> s1 = new Stack<>();
        final Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(-1);
        int r = 0;
        int n = 0, m = 0, sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || r != 0) {
            if (s1.isEmpty()) n = 0;
            else n = s1.pop();
            if (s2.isEmpty()) m = 0;
            else m = s2.pop();
            sum = m + n + r;
            ListNode newHead = new ListNode(sum % 10);
            r = sum / 10;

            // 头插法
            newHead.next = dummy.next;
            dummy.next = newHead;
        }

        return dummy.next;

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        int r = 0;
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            dummy.next = new ListNode((sum + r) % 10);
            r = (sum + r) / 10;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val;
            dummy.next = new ListNode((sum + r) % 10);
            r = (sum + r) / 10;
            dummy = dummy.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val;
            dummy.next = new ListNode((sum + r) % 10);
            r = (sum + r) / 10;
            dummy = dummy.next;
            l2 = l2.next;
        }

        while (r > 0) {
            dummy.next = new ListNode(r % 10);
            r = r / 10;
        }

        return reverse(dummyHead.next);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;

        return root;
    }
}
