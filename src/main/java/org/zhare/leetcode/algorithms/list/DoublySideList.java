package org.zhare.leetcode.algorithms.list;

/**
 * @author dennis
 * @since 2019/11/7
 */
public class DoublySideList {
    private static Node head;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        head = build(arr);
        print(head);
        Node found = find(8, head);
        assert found != null;
        System.out.println(found.value);
        add(10);
        print(head);
        remove(10);
        print(head);
        remove(1);
        print(head);
        remove(10);
        print(head);
        remove(5);
        print(head);
    }

    private static Node find(int value, Node head) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return current;
            current = current.next;
        }

        return null;
    }

    private static Node getLastNode(Node head) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }

    private static void add(int value) {
        Node tail = getLastNode(head);
        Node node = new Node(value);
        node.prev = tail;
        tail.next = node;
    }

    private static void remove(int value) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current.value == value) break;
            prev = current;
            current = current.next;
        }

        // 未找到
        if (current == null) return;
        // 头节点
        if (prev == null) {
            current.prev = null;
            head = current.next;
            return;
        }
        // 尾节点
        if (current.next == null) {
            prev.next = null;
            current.prev = null;
            return;
        }
        // 一般节点
        Node next = current.next;
        prev.next = next;
        next.prev = prev;

        current.next = null;
        current.prev = null;
    }

    private static void print(Node head) {
        if (head == null) return;
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static Node build(int[] arr) {
        if (arr == null || arr.length < 1) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; ++i) {
            Node node = new Node(arr[i]);

            node.prev = current;
            current.next = node;
            current = node;
        }

        return head;
    }

    static class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node(int vale) {
            this.value = vale;
        }
    }
}
