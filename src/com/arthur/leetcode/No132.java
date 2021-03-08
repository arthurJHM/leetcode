package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @title: No132
 * @Author ArthurJi
 * @Date: 2021/3/8 9:45
 * @Version 1.0
 */
public class No132 {
    public static void main(String[] args) {
        new No132().minCut("aab");
    }

    int ans = Integer.MAX_VALUE;

//    和131不一样，131要求出所有的可能序列，但是这题只需要求出最小的就行，并且回溯在这题中会超时，所以得用dp,
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            huiwen(s, dp, i, i);
            huiwen(s, dp, i, i + 1);
        }
//        dfs(dp, s, 0, 0);
        int ansdp[] = new int[len];
        Arrays.fill(ansdp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                ansdp[i] = 0;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    ansdp[i] = Math.min(ansdp[i], ansdp[j] + 1);
                }
            }
        }
        return ansdp[len - 1];
    }

    private void dfs(boolean[][] dp, String s, int deep, int num) {
        if (deep == s.length()) {
            ans = Math.min(ans, num);
            return;
        }
        if (num >= ans) {
            return;
        }
        for (int i = deep; i < s.length(); i++) {
            if (dp[deep][i]) {
                dfs(dp, s, i + 1, num + 1);
            }
        }
  /*      for (int i = s.length() - 1; i >= deep; i--) {
            if (dp[deep][i]) {
                dfs(dp, s, i + 1, num + 1);
            }
        }*/
      /*  for (int i = s.length() - 1; i >= deep; i--) {
            if (dp[deep][i]) {
                dfs(dp, s, i + 1, num + 1);
                break;
            }
        }*/
    }

    private void huiwen(String s, boolean[][] dp, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = true;
            i--;
            j++;
        }
    }
}
/*132. 分割回文串 II
        给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。

        返回符合要求的 最少分割次数 。



        示例 1：

        输入：s = "aab"
        输出：1
        解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
        示例 2：

        输入：s = "a"
        输出：0
        示例 3：

        输入：s = "ab"
        输出：1*/
