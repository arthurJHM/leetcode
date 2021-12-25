package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 连续子数组的最大和
 * @title: JZoffer42
 * @Author hengmingji
 * @Date: 2021/12/25 14:54
 * @Version 1.0
 */
public class JZoffer42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
