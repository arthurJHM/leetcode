package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 丑数 II
 * @title: No264_2
 * @Author hengmingji
 * @Date: 2021/12/29 11:17
 * @Version 1.0
 */
public class No264_2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int d2 = 0;
        int d3 = 0;
        int d5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[d2] * 2;
            int n3 = dp[d3] * 3;
            int n5 = dp[d5] * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            if (min == n2) {
                d2++;
            }
            if (min == n3) {
                d3++;
            }
            if (min == n5) {
                d5++;
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}
