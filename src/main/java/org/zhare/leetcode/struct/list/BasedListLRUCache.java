package org.zhare.leetcode.struct.list;

/**
 * @author dennis
 * @since 2019/11/6
 */
public class BasedListLRUCache {

    private int size;

    private static Node head;
    private static Node tail;

    public static void main(String[] args) {

    }


    static class LinkedList {
        private static Node head;
        private static Node tail;

        private static int size;

        private final int capacity;

        public LinkedList(int capacity) {
            head = null;
            tail = null;
            this.capacity = capacity;
        }

        public int get(int key) {
            int result = doGet(key);
            if (result != -1) return result;

            if (size == capacity) {

            } else {

            }
            return -1;
        }

        private void addToHead(int key) {
            Node node = new Node(key, key);
            if (head == null) {
                head = tail = node;
                return;
            }

            node.next = head;
            head = node;
        }

        public int doGet(int key) {
            if (head == null) return -1;
            Node prev = null;
            Node node = head;
            while (node != null) {
                if (node.key == key) {
                    mvToHead(prev, node);
                    return node.value;
                }
                prev = node;
                node = node.next;
            }

            return -1;
        }

        private void mvToHead(Node prev, Node node) {
            if (node == null || node == head) return;


            prev.next = node.next;
            node.next = head.next;
            head = node;
        }

    }


    static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
