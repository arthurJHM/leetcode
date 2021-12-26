package com.arthur.leetcode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 把数字翻译成字符串
 * @title: JZoffer46
 * @Author hengmingji
 * @Date: 2021/12/26 12:59
 * @Version 1.0
 */
public class JZoffer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        if (10 <= Integer.valueOf(s.substring(0, 2)) && Integer.valueOf(s.substring(0, 2)) <= 25) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            if (10 <= Integer.valueOf(s.substring(i - 1, i + 1)) && Integer.valueOf(s.substring(i - 1, i + 1)) <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}
