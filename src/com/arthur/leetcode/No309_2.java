package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 最佳买卖股票时机含冷冻期_二刷
 * @title: No309_2
 * @Author hengmingji
 * @Date: 2021/12/26 13:31
 * @Version 1.0
 */
public class No309_2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3]; //0 持有 1不持有且不是当天卖的// 2不持有且当天卖的
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
