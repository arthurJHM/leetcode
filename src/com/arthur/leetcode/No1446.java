package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 连续字符
 * @title: No1446
 * @Author hengmingji
 * @Date: 2021/12/25 16:10
 * @Version 1.0
 */
public class No1446 {
    public int maxPower(String s) {
        int ans = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
