package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: II. 青蛙跳台阶问题
 * @title: JZoffer10_2
 * @Author hengmingji
 * @Date: 2021/12/24 14:56
 * @Version 1.0
 */
public class JZoffer10_2 {
    public int numWays(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
