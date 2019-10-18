package org.zhare.leetcode.algorithms;


/**
 * @author xufeng.deng dennisdxf@gmail.com
 * @since 2018-08-21 20:24
 */
public class Eight {
    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(atoi(str));
    }

    private static int atoi(String str) {
        if (null == str || str.isEmpty()) {
            return 0;
        }

        str = str.trim();
        int sign = 1;
        int start = 0;
        int length = str.length();
        if ('+' == str.charAt(start)) {
            sign = 1;
            ++start;
        } else if ('-' == str.charAt(start)) {
            sign = -1;
            ++start;
        }

        long sum = 0;
        for (int i = start; i < length; ++i) {
            if (!Character.isDigit(str.charAt(i))) return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }



}
