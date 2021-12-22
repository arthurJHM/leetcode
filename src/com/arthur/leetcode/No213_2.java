package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 打家劫舍 II
 * @title: No213_2
 * @Author hengmingji
 * @Date: 2021/12/21 15:05
 * @Version 1.0
 */
public class No213_2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        return Math.max(rob_(Arrays.copyOfRange(nums, 1, len)), rob_(Arrays.copyOfRange(nums, 0, len - 1)));
    }
    private int rob_(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i -2] + nums[i]);
        }
        return dp[len - 1];
    }
}
