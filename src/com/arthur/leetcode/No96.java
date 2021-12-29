package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 不同的二叉搜索树 卡特兰数
 * @title: No96
 * @Author hengmingji
 * @Date: 2021/12/29 11:00
 * @Version 1.0
 */
public class No96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
