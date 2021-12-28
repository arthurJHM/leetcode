package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 解码方法 _ 二刷
 * @title: No91_2
 * @Author hengmingji
 * @Date: 2021/12/28 14:16
 * @Version 1.0
 */
public class No91_2 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        int[] nums = new int[len + 1];
        for (int i = 1; i <= s.length(); i++) {
            nums[i] = Integer.valueOf(s.charAt(i - 1) - '0');
        }
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int n = nums[i - 1] * 10 + nums[i];
            if (nums[i] >= 1 && nums[i] <= 9) {
                dp[i] = dp[i - 1];
            }
            if (n >= 10 && n <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
