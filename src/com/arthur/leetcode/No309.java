package com.arthur.leetcode;

/**
 * @title: No309
 * @Author ArthurJi
 * @Date: 2021/2/20 23:06
 * @Version 1.0
 */
public class No309 {
    public static void main(String[] args) {
        System.out.println(new No309().maxProfit(new int[]{1,2,3,0,2}));
    }
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // res[i][0]: 手上持有股票的最大收益
        // res[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // res[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] res = new int[len][3];
        res[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            res[i][0] = Math.max(res[i - 1][0], res[i - 1][2] - prices[i]);
            res[i][1] = res[i - 1][0] + prices[i];
            res[i][2] = Math.max(res[i - 1][2], res[i - 1][1]);
        }

        return Math.max(res[len - 1][1], res[len - 1][2]);
    }
}
