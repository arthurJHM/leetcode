package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 使用最小花费爬楼梯
 * @title: No746
 * @Author hengmingji
 * @Date: 2021/12/20 17:05
 * @Version 1.0
 */
public class No746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
