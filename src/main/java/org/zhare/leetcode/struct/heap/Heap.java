package org.zhare.leetcode.struct.heap;

import java.util.Arrays;

/**
 * @author dennis
 * @since 2019/11/17
 */
public class Heap {
    /*
     * 堆
     * 1.完全二叉树 2.所有节点的值大于/小于左右节点的值
     *
     * O(n)
     * */

    private static int size;
    private static int[] heap;
    private static int count;

    public static void main(String[] args) {
        int[] values = new int[]{4, 5, 3, 2, 7, 0, 1, 8, 6};
        heap = build(values);
        print(heap, values.length);
        System.out.println(offer(9));
        print(heap, count);
        offer(3);
        offer(4);
        offer(1);
        print(heap, count);
        System.out.println(poll());
        print(heap, count);
        System.out.println(Arrays.toString(sort(heap)));
    }

    private static int[] sort(int[] heap) {
        int[] values = new int[count];
        int len = count;
        for (int i = 0; i < len; ++i) {
            int value = poll();
            values[i] = value;
        }
        return values;
    }

    private static void print(int[] values, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    private static int[] build(int[] values) {
        size = values.length * 2;
        int[] heap = new int[size];
        count = values.length;
        for (int i = 0; i < values.length; ++i) {
            insert(heap, values[i], i);
        }

        return heap;
    }

    private static int poll() {
        if (count <= 0) return -1;
        int value = heap[0];
        int newRoot = heap[count - 1];
        heap[0] = newRoot;
        siftDown(0, newRoot, heap, count - 1);
        count--;

        return value;
    }

    private static boolean offer(int value) {
        if (count + 1 > size) return false;
        insert(heap, value, count);
        count++;
        return true;
    }


    private static void insert(int[] values, int value, int i) {
        siftUp(i, value, values);
    }

    private static void siftDown(int index, int value, int[] values, int len) {
        int i = index;
        int root = len >>> 1;
        while (i < root) {
            int child = (i << 1) + 1;
            int right = child + 1;
            int childValue = values[child];
            if (right < len && values[child] > values[right]) {
                child = right;
                childValue = values[right];
            }

            if (childValue >= value) break;

            values[i] = childValue;
            i = child;
        }

        values[i] = value;
    }

    private static void siftUp(int index, int value, int[] values) {
        int k = index;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            if (values[parent] <= value) break;
            values[k] = values[parent];
            k = parent;
        }

        values[k] = value;
    }
}
