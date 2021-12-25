package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机 II ——二刷
 * @title: No122_2
 * @Author hengmingji
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/best-time-to-buy-and-sell-stock-ii-zhuan-hua-fa-ji/
 * 等价于每天都买卖
 * @Date: 2021/12/25 15:32
 * @Version 1.0
 */
public class No122_2 {
    public int maxProfit(int[] prices) {
        int temp;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - prices[i - 1];
            if(temp > 0) {
                ans += temp;
            }
        }
        return ans;
    }
}
