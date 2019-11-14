package org.zhare.leetcode.algorithms.stack;

/**
 * @author dennis
 * @since 2019/11/11
 */
public class NormalStack {
    private int[] items;
    private int capacity;
    private int count;

    public NormalStack(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.items = new int[capacity];
    }

    public static void main(String[] args) {

    }

    private boolean push(int value) {
        if (count == capacity) return false;
        items[count++] = value;
        return true;
    }

    private int pop() {
        if (count == 0) return -1;
        return items[count--];
    }

}
