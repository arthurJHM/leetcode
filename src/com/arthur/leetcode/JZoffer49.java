package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 丑数
 * @title: JZoffer49
 * @Author hengmingji
 * @Date: 2022/1/15 22:32
 * @Version 1.0
 */
public class JZoffer49 {
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int l = 1; l < n; l++) {
            dp[l] = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (dp[l] == dp[i] * 2) {
                i++;
            }
            if (dp[l] == dp[j] * 3) {
                j++;
            }
            if (dp[l] == dp[k] * 5) {
                k++;
            }
        }
        return dp[n - 1];
    }
}
