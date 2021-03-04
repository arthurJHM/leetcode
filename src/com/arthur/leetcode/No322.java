package com.arthur.leetcode;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.WebParamMode;

/**
 * @title: No322
 * @Author ArthurJi
 * @Date: 2021/3/4 19:49
 * @Version 1.0
 */
public class No322 {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if(coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
/*
322. 零钱兑换
        给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

        你可以认为每种硬币的数量是无限的。



        示例 1：

        输入：coins = [1, 2, 5], amount = 11
        输出：3
        解释：11 = 5 + 5 + 1
        示例 2：

        输入：coins = [2], amount = 3
        输出：-1
        示例 3：

        输入：coins = [1], amount = 0
        输出：0
        示例 4：

        输入：coins = [1], amount = 1
        输出：1
        示例 5：

        输入：coins = [1], amount = 2
        输出：2*/
