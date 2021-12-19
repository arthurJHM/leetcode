package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 第 N 个泰波那契数
 * @title: No1137
 * @Author hengmingji
 * @Date: 2021/12/19 18:53
 * @Version 1.0
 */
public class No1137 {
    public int tribonacci(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n < 3) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
