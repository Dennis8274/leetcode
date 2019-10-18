package org.zhare.leetcode.algorithms.list;

/**
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2019/10/17
 */
public class ListNormalOps {
    public static void main(String[] args) {
        int[] values = {1, 3, 5, 7, 9};
        Node head = build(values);
        Node find = find(head, 5);
        if (find != null) System.out.println("find node: " + find.val);
        Node insert = insert(find, 6);
        print(head);

        del(find, insert);
        print(head);
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node build(int[] values) {
        if (values.length < 1) return null;
        Node head = new Node(values[0]);
        Node cur = head;
        for (int i = 1; i < values.length; ++i) {
            Node node = new Node(values[i]);
            cur.next = node;
            cur = node;
        }

        return head;
    }

    private static void del(Node prev, Node cur) {
        if (cur == null) return;
        if (prev == null) {
            cur.next = null;
            return;
        }

        prev.next = cur.next;
        cur.next = null;
    }

    private static Node insert(Node prev, int val) {
        if (prev == null) return null;
        Node next = prev.next;
        Node node = new Node(val);
        prev.next = node;
        node.next = next;
        return node;
    }

    private static Node find(Node head, int val) {
        Node node = head;
        while (node != null) {
            if (node.val == val) return node;
            node = node.next;
        }

        return null;
    }

    static class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
