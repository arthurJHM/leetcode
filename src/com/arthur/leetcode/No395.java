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
        if (s.length() < k) {
            return 0;
        }
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            hashmap.put(key ,hashmap.getOrDefault(key, 0 ) + 1);
        }
        int max = 0;
        for (String key : hashmap.keySet()) {
            if(hashmap.get(key) < k) {
                for (String item : s.split(key)) {
                    max = Math.max(longestSubstring(item, k), max);
                }
                return max;
            }
        }
        return s.length();
    }
}