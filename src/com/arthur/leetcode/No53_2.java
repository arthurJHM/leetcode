package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二刷
 * @title: No53_2
 * @Author hengmingji
 * @Date: 2021/12/23 13:23
 * @Version 1.0
 */
public class No53_2 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
