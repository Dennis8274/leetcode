package org.zhare.leetcode.struct.list;

/**
 * @author dennis
 * @since 2019/11/7
 */
public class ReverseList {

    private static Node head;

    public static void main(String[] args) {
        int[] vales = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        head = build(vales);
        print(head);
        head = reverse(head);
        print(head);
        head = reverse2(head);
        print(head);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static Node reverse2(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Node node = reverse2(head.next);
        Node next = head.next;
        next.next = head;
        head.next = null;

        return node;
    }

    private static void print(Node head) {
        if (head == null) return;
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
