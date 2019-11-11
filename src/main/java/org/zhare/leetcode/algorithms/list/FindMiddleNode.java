package org.zhare.leetcode.algorithms.list;

/**
 * @author dennis
 * @since 2019/11/8
 */
public class FindMiddleNode {
    private static Node head;

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        head = build(values);
        print(head);
        Node mid = findMiddleNode(head);
        System.out.println(mid == null ? "null" : mid.val);
    }

    private static Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = slow;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void print(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
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
