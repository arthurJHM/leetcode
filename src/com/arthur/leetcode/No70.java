package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 爬楼梯
 * @title: No70
 * @Author hengmingji
 * @Date: 2021/12/20 17:01
 * @Version 1.0
 */
public class No70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
