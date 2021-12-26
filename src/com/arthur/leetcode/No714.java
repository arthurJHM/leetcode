package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机含手续费
 * @title: No714
 * @Author hengmingji
 * @Date: 2021/12/26 13:55
 * @Version 1.0
 */
public class No714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2]; //0持有  1不持有
        dp[0][0] = -prices[0] - fee;
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}
