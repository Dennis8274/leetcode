package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/12/28
 */
public class ThreeTwoEight {
    /*
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        ListNode root = ListNode.build(nums);
        ListNode.print(root);
        ListNode.print(oddEvenList(root));

    }

    private static ListNode oddEvenList(ListNode root) {
        if (root == null || root.next == null) return root;
        ListNode cur = root;
        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;
        while (cur != null) {
            odd.next = cur;
            odd = odd.next;
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
            if (cur != null) {
                even.next = cur;
                even = even.next;
                ListNode tmp1 = cur.next;
                cur.next = null;
                cur = tmp1;
            }
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }


}
