package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/28
 */
public class NineTwo {
    /*
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明: 1 ≤ m ≤ n ≤ 链表长度。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int m = 1, n = 4;
        ListNode head = ListNode.build(nums);
        ListNode reverseNode = reverseBetween2(head, m, n);
        ListNode.print(reverseNode);
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m <= 0 && n <= 0) throw new IllegalArgumentException();
        if (head == null || m >= n || n == 1) return head;
        ListNode last = null;
        ListNode mth = head;
        int th = m;
        while (mth != null && --th > 0) {
            last = mth;
            mth = mth.next;
        }

        if (mth == null) return head;

        ListNode pre = mth;
        ListNode cur = pre;
        ListNode next = null;
        n = n - m + 1;
        while (cur != null && n-- > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (last != null) {
            last.next = pre;
        } else {
            head = pre;
        }
        if (cur != null)
            mth.next = next;
        else mth.next = null;

        return head;
    }

    private static ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < m - 1; ++i)
            prev = prev.next;
        ListNode head2 = prev; // 1

        prev = head2.next; // 2
        ListNode cur = prev.next; // 3
        for (int i = m; i < n; ++i) {
            prev.next = cur.next; // 2->4
            cur.next = head2.next;  // 3->1
            head2.next = cur;  // 头插法 1->3
            cur = prev.next; // 4
        }

        return dummy.next;
    }
}
