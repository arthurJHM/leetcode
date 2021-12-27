package com.arthur.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @program: leetcode
 * @description: 单词拆分_二刷
 * @title: No139_2
 * @Author hengmingji
 * @Date: 2021/12/27 14:02
 * @Version 1.0
 */
public class No139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
