package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机
 * @title: No121
 * @Author hengmingji
 * @Date: 2021/12/25 15:17
 * @Version 1.0
 */
public class No121 {
    public int maxProfit(int[] prices) {
        int preMin = prices[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans,prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return ans < 0 ? 0 : ans;
    }
}
