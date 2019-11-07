package org.zhare.leetcode.algorithms.list;

/**
 * @author dennis
 * @since 2019/11/8
 */
public class MergeTwoOrderedList {

    public static void main(String[] args) {
        int[] firstValues = new int[]{1, 3, 5, 7, 9};
        int[] secondValues = new int[]{2, 4, 6, 8};
        Node first = build(firstValues);
        print(first);
        Node second = build(secondValues);
        print(second);
        Node newHead = merge(first, second);
        print(newHead);
    }

    private static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        Node head;
        if (first.value < second.value) {
            head = first;
            first = first.next;
        } else {
            head = second;
            second = second.next;
        }
        Node cur = head;
        while (first != null && second != null) {
            Node node;
            if (first.value < second.value) {
                node = first;
                first = first.next;
            } else {
                node = second;
                second = second.next;
            }
            cur.next = node;
            cur = node;
        }
        if (first != null) cur.next = first;
        else cur.next = second;

        return head;
    }

    private static void print(Node node) {
        if (node == null) return;
        while (node != null) {
            System.out.print(node.value + " ");
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
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
