package org.zhare.leetcode.struct.list;

/**
 * @author dennis
 * @since 2019/11/8
 */
public class RemoveLastNNode {
    /*
     * 删除倒数第n个节点
     *
     * 双指针
     *
     * */

    private static Node head;

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        head = build(values);
        print(head);
        head = removeLastN(head, 5);
        print(head);
    }

    private static Node removeLastN(Node head, int n) {
        Node slow = head;
        Node fast = slow;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    private static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static Node build(int[] values) {
        if (values == null || values.length < 1) return null;
        Node head = new Node(values[0]);
        Node cur = head;
        for (int i = 1; i < values.length; ++i) {
            Node node = new Node(values[i]);
            cur.next = node;
            cur = node;
        }

        return head;
    }


    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
