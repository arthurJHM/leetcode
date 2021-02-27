package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @title: No395
 * @Author ArthurJi
 * @Date: 2021/2/27 14:32
 * @Version 1.0
 */
public class No395 {
    public static void main(String[] args) {

    }

    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
