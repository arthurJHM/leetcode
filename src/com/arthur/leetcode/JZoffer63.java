package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 股票的最大利润
 * @title: JZoffer63
 * @Author hengmingji
 * @Date: 2021/12/24 14:59
 * @Version 1.0
 */
public class JZoffer63 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i- 1], prices[i] - min);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}