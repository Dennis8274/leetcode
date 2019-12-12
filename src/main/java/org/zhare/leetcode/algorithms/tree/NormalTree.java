package org.zhare.leetcode.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author dennis
 * @since 2019/12/1
 */
public class NormalTree {

    private static Node root;

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        root = build(values);
        printTree(root);
//        System.out.println("===========");
//        preOrder(root);
//        System.out.println();
//        System.out.println("===========");
//        nonRecursivePreOrder(root);
//        System.out.println();
//        System.out.println("===========");
//        inOrder(root);
//        System.out.println();
//        System.out.println("===========");
//        nonRecursiveInOrder(root);
//        System.out.println();
//        System.out.println("===========");
//        mirrorsInOrder(root);

//        System.out.println();
//        int[] preOrder = new int[]{1, 2, 4, 8, 5, 3, 6, 7};
//        int[] inOrder = new int[]{8, 4, 2, 5, 1, 6, 3, 7};
//        Node node = buildTree(preOrder, inOrder);
//        nonRecursiveInOrder(node);

        System.out.println("========");
        int maxDepth = maxDepth(root);
        System.out.println("max depth is " + maxDepth);
        int minDepth = minDepth(root);
        System.out.println("min depth is " + minDepth);
        int nodeNums = nodeNums(root);
        System.out.println("node nums is " + nodeNums);
        int leafNums = leafNums(root);
        System.out.println("leaf nums is " + leafNums);
        int nodeNumsOnKthLevel = nodeNumsOnKthLevel(root, 4);
        System.out.println("node nums on kth level is " + nodeNumsOnKthLevel);
    }

    private static int maxDepth(Node root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    private static int minDepth(Node root) {
        if (root == null) return 0;
        return getMin(root);
    }

    private static int getMin(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    private static int nodeNums(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return nodeNums(root.left) + nodeNums(root.right) + 1;
    }

    private static int leafNums(Node root) {
        if (root == null) return 1;
        return getLeafNums(root);
    }

    private static int getLeafNums(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return getLeafNums(root.left) + getLeafNums(root.right);
    }

    private static int nodeNumsOnKthLevel(Node root, int k) {
        if (root == null || k < 1) return 0;
        if (k == 1) return 1;
        int left = nodeNumsOnKthLevel(root.left, k - 1);
        int right = nodeNumsOnKthLevel(root.right, k - 1);
        return left + right;
    }

    private static Node buildTree(int[] preOrder, int[] inOrder) {
        return build(preOrder, 0, preOrder.length - 1, inOrder, 0);
    }

    private static int rootIndex(int[] inOrder, int value) {
        for (int i = 0; i < inOrder.length; ++i) {
            if (value == inOrder[i]) return i;
        }
        return -1;
    }

    private static Node build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart) {
        if (preStart > preEnd) return null;
        Node head = new Node(preOrder[preStart]);
        int rootIndex = rootIndex(inOrder, preOrder[preStart]);
        int leftLen = rootIndex - inStart;
        head.left = build(preOrder, preStart + 1, preStart + leftLen, inOrder, inStart);
        head.right = build(preOrder, preStart + leftLen + 1, preEnd, inOrder, rootIndex + 1);

        return head;
    }

    private static void printTree(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            count++;
            if (isLikePowOfTwo(count)) System.out.println();

            Node left = cur.left;
            if (left != null) queue.add(left);
            Node right = cur.right;
            if (right != null) queue.add(right);
        }
        System.out.println();
    }

    private static void nonRecursiveInOrder(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }

    /**
     * 利用栈作为辅助数据结构的实现中，时间复杂度为O(n)已经是最优的了，但是空间复杂度是O(h)[h 为树高度]是可以进行优化的
     * <p>
     * 栈中保存的信息是当前节点的父节点，要实现O(1)的空间复杂度，就需要在不依靠额外的空间的情况下，在遍历的过程中保存父节点信息，这个时候可以利用为空的子节点
     * <p>
     * 如下：
     * （1）如果当前节点的左孩子为空，则访问当前节点的值并将其右孩子作为当前节点。
     * （2）如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
     * a.如果前驱节点的右孩子为空，将它的右孩子设置为当前节点，并且将当前节点更新为当前节点的左孩子。
     * b.如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空，访问当前节点的值，并且将当前节点更新为当前节点的右孩子。
     * （3） 重复以上（1）、（2）直到当前节点为空。
     */
    private static void mirrorsInOrder(Node root) {
        if (root == null) return;
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;    //  左子树的最右节点就是当前节点的前驱节点
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {    // prev.right == cur
                    prev.right = null;
                    System.out.print(cur.val + " ");
                    cur = cur.right;
                }
            }
        }
    }

    private static void nonRecursivePreOrder(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);
        }
    }

    private static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static boolean isLikePowOfTwo(int val) {
        int n = 1;
        while (n <= val) {
            n <<= 1;
        }

        return val + 1 == n;
    }

    private static Node build(int[] values) {
        if (values == null || values.length < 1) return null;

        Node root = new Node(values[0]);
        Node cur = root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(cur);
        int len = values.length;
        int index = 1;
        while (index < len) {
            Node left = new Node(values[index++]);
            cur = queue.poll();

            cur.left = left;
            queue.offer(left);
            if (index >= len) break;

            Node right = new Node(values[index++]);
            cur.right = right;
            queue.offer(right);
        }

        return root;
    }


    static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
