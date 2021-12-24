package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: I. 斐波那契数列
 * @title: JZoffer10
 * @Author hengmingji
 * @Date: 2021/12/24 14:53
 * @Version 1.0
 */
public class JZoffer10 {
    public int fib(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 ;
        }
        return dp[n];
    }
}
