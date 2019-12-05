package org.zhare.leetcode.algorithms.list;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dennis
 * @since 2019/11/16
 */
public class SkipList {
    /*
     * 跳表
     * */

    private static final int MAX_LEVEL = 16;

    private static Node head = new Node(-1);

    private static int maxLevel = 0;

    public static void main(String[] args) {
        int[] values = new int[]{9, 7, 6, 5, 4, 3, 1, 0, 23, 69, 19, 20, 11, 39, 50, 39, 59, 28, 17, 8, 10, 2, 67, 100};
        for (int value : values) {
            insert(value);
        }
        printAll(head);
        System.out.println("find: ");
        Node found = find(100);
        System.out.println(found.maxLevel);

        System.out.println("del node: ");
        delete(0);
        printAll(head);
    }

    private static void printAll(Node head) {
        int level = maxLevel;
        for (int i = level - 1; i >= 0; --i) {
            Node node = head.forwards[i];
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.forwards[i];
            }
            System.out.println();
        }
    }

    private static Node find(int value) {
        int level = maxLevel;
        Node node = head;
        for (int i = level - 1; i >= 0; --i) {
            while (node.forwards[i] != null && node.forwards[i].val < value) {
                node = node.forwards[i];
            }
        }

        if (node.forwards[0] != null && node.forwards[0].val == value) return node.forwards[0];
        return null;
    }

    private static void delete(int value) {
        int level = maxLevel;
        Node node = head;

        // find every predecessor
        for (int i = level - 1; i >= 0; --i) {
            while (node.forwards[i] != null && node.forwards[i].val < value) {
                node = node.forwards[i];
            }
        }

        // update
        if (node.forwards[0] != null && node.forwards[0].val == value) {
            // should update every level
            for (int i = level - 1; i >= 0; --i) {
                if (node.forwards[i] != null && node.forwards[i].val == value) // if it is del-node ,then rm this node in this level
                    node.forwards[i] = node.forwards[i].forwards[i];
            }
        }

        // recursive shrink level count
        while (maxLevel > 1 && head.forwards[maxLevel - 1] == null) {
            maxLevel--;
        }
    }

    private static void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node(value);

        // insert
        Node node = head;
        for (int i = level - 1; i >= 0; --i) {
            // find insert pos
            while (node.forwards[i] != null && node.forwards[i].val < value) {
                node = node.forwards[i];
            }
            // find node is predecessor
            newNode.forwards[i] = node.forwards[i];
            node.forwards[i] = newNode;
            if (newNode.maxLevel < i) newNode.maxLevel = i;
        }

        if (maxLevel < level) maxLevel = level;
    }

    private static int randomLevel() {
        int level = 0;
        for (int i = 0; i < MAX_LEVEL; ++i) {
            if (ThreadLocalRandom.current().nextInt(MAX_LEVEL) % 2 == 1) level++;
        }
        return level;
    }

    static class Node {
        private int val;
        private int maxLevel;
        private Node[] forwards = new Node[MAX_LEVEL];

        public Node(int val) {
            this.val = val;
        }
    }
}
