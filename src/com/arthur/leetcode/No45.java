package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 跳跃游戏 II
 * @title: No45
 * @Author hengmingji
 * @Date: 2021/12/22 21:52
 * @Version 1.0
 */
public class No45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int jump1(int[] nums) {
        int count = 0;
        int start = 0;
        int max = 0;
        int end = 1;
        while (end < nums.length) {
            for (int j = start; j < end; j++) {
                max = Math.max(max, j + nums[j]);
            }
            start = end;
            end = max + 1;
            count++;
        }
        return count;
    }
}
