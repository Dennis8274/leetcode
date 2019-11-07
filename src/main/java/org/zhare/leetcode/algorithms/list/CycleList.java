package org.zhare.leetcode.algorithms.list;

/**
 * @author dennis
 * @since 2019/11/6
 */
public class CycleList {
    private static Node head;
    private static Node tail;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        buildCycleList(arr);
        System.out.println(judgeCycle());
        System.out.print(josephus(arr.length, 2));
        System.out.println();
        System.out.println(josephus2(arr.length - 1, 2));
    }

    private static int josephus2(int n, int m) {
        int s = 0;
        for (int i = 2; i <= n; i++)
            s = (s + m) % i;
        return s;
    }

    private static int josephus(int n, int m) {
        if (m == 1) {
            return printAndGetLast();
        }
        Node prev = null;
        Node current = head;
        while (current.next != current) {
            for (int i = 0; i < m; ++i) {
                prev = current;
                current = current.next;
            }
            System.out.print(current.value + " ");
            // delNode
            prev.next = current.next;
            current = prev.next;
        }

        return current.value;
    }

    private static boolean judgeCycle() {
        Node node = head;
        while (node != null) {
            node = node.next;
            if (node == head) return true;
        }

        return false;
    }

    private static int printAndGetLast() {
        Node node = head;
        while (node.next != head) {
            System.out.print(node.value + " ");
            node = node.next;
        }

        return node.value;
    }

    private static void buildCycleList(int[] arr) {
        if (arr == null || arr.length < 1) return;
        head = new Node(arr[0]);
        Node node = head;
        for (int i = 1; i < arr.length; ++i) {
            Node newNode = new Node(arr[i]);
            node.next = newNode;
            node = newNode;
        }

        node.next = head;
        tail = node;
    }


    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
