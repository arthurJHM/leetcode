package com.arthur.leetcode;

import javax.print.attribute.standard.MediaSize;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description: 最长重复子串
 * @title: No1044
 * @Author hengmingji
 * @Date: 2021/12/23 10:51
 * @Version 1.0
 */
public class No1044 {
    public String longestDupSubstring(String s) {
        int P = 1313131;
        int len = s.length();
        long[] hash = new long[len + 1];
        long[] p = new long[len + 1];
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            hash[i + 1] = hash[i] * P + s.charAt(i);//错位放置 从1开始
            p[i + 1] = p[i] * P;
        }
        String ans = "";
        int left = 0;
        int right = len;
        int mid;
        String temp;
        while (left <= right) {
            mid = (left + right) / 2;
            temp = check(mid, s, hash, p);
            if (temp.length() != 0) {//能覆盖 向上收缩
                left = mid + 1;
            } else {//不能覆盖 向下收缩
                right = mid - 1;
            }
            ans = temp.length() > ans.length() ? temp : ans;
        }
        return ans;
    }

    private String check(int len, String s, long[] hash, long[] p) {
        HashSet<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= s.length(); i++) {
            int j = i + len - 1;
            long n = hash[j] - hash[i - 1] * p[j - i + 1];
            if (set.contains(n)) {
                return s.substring(i - 1, j);
            }
            set.add(n);
        }
        return "";
    }
}
