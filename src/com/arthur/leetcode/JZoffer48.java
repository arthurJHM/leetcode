package com.arthur.leetcode;

import java.util.HashSet;

/**
 * @program: leetcode
 * @description: 最长不含重复字符的子字符串
 * @title: JZoffer48
 * @Author hengmingji
 * @Date: 2021/12/26 13:22
 * @Version 1.0
 */
public class JZoffer48 {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
