package org.zhare.leetcode.algorithms;

/**
 * @author dennis
 * @since 2019/11/14
 */
public class ValidaAnagram {
    /*
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 242
     *  */

    public static void main(String[] args) {
        String s = "anagram", String, t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;

        int[] table = new int[26];
        char[] ss = s.toCharArray();
        for (char ch : ss) {
            table[ch - 'a']++;
        }

        char[] tt = t.toCharArray();
        for (char ch : tt) {
            table[ch - 'a']--;
            if (table[ch - 'a'] < 0) return false;
        }

        return true;
    }
}
