package org.zhare.leetcode.struct.list;

/**
 * @author dennis
 * @since 2019/11/8
 */
public class DetectCycleList {
    private static Node head;

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        head = buildCycleList(values);
        print(head);
        System.out.println(detect(head));

    }

    private static void print(Node head) {
        Node node = head;
        while (node != null && node.next != head) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        if (node == null) {
            System.out.println();
            return;
        }
        System.out.print(node.value);
        System.out.println();
    }

    private static boolean detect(Node head) {
        if (head == null) return false;
        Node cur = head;
        while (cur.next != null && cur.next != head) {
            cur = cur.next;
        }
        return cur.next != null;
    }

    private static Node buildCycleList(int[] values) {
        if (values == null || values.length < 1) return null;
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; ++i) {
            Node node = new Node(values[i]);
            current.next = node;
            current = node;
        }
        current.next = head;
        return head;
    }

    static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
