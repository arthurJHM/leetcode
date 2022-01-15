package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: n个骰子的点数
 * @title: JZoffer60
 * @Author hengmingji
 * @Date: 2022/1/15 22:52
 * @Version 1.0
 */
public class JZoffer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[1 + 5 * i];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 1; k <= 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
