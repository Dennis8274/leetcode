package org.zhare.leetcode.algorithms.list;

/**
 * @author dennis
 * @since 2019/11/7
 */
public class ReverseList {

    private static Node head;

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        head = build(values);
        print(head);
        head = reverse2(head);
        print(head);
        head = reverse(head);
        print(head);

    }

    private static Node reverse2(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node prev = null;
        Node cur = first;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        cur.next = prev;

        return cur;
    }

    private static Node reverse(Node node) {
        if (node == null) return null;
        if (node.next == null) return node;
        Node head = reverse(node.next);
        Node next = node.next;
        next.next = node;
        node.next = null;
        return head;
    }

    private static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static Node build(int[] values) {
        if (values == null || values.length < 1) {
            return null;
        }

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
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
