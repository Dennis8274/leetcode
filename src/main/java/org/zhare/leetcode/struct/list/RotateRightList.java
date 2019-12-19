package org.zhare.leetcode.struct.list;

/**
 * @author dennis
 * @since 2019/11/9
 */
public class RotateRightList {

    /*
    * 61 旋转链表
    *
    * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    * */

    private static Node head;

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        head = build(values);
        print(head);
        head = rotate(head, 2);
        print(head);

    }

    private static Node rotate(Node head, int n) {
        if (head == null) return null;
        if (head.next == null) return head;

        int size = 1;
        Node node = head;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        node.next = head;

        n = n % size;
        // size-n 前几个
        Node tail = head;
        for (int i = 1; i < size - n; i++) {
            head = head.next;
        }
        Node newHead = head.next;

        head.next = null;
        return newHead;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node build(int[] values) {
        if (values == null || values.length < 1) return null;
        Node head = new Node(values[0]);
        Node node = head;
        for (int i = 1; i < values.length; ++i) {
            Node cur = new Node(values[i]);
            node.next = cur;
            node = cur;
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
