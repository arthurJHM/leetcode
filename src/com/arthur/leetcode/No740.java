package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @title: No740
 * @Author hengmingji
 * @Date: 2021/12/20 20:28
 * @Version 1.0
 */
public class No740 {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Integer.max(max, num);
        }
        int[] count = new int[max + 1];
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        dp[0] = 0;
        dp[1] = count[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i] * i);
        }
        return dp[max];
    }
}
