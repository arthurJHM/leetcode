package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 斐波那契数
 * @title: No509
 * @Author hengmingji
 * @Date: 2021/12/19 18:47
 * @Version 1.0
 */
public class No509 {
    public int fib(int n) {
        if(n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
