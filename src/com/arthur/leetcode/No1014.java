package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 最佳观光组合
 * @title: No1014
 * @Author hengmingji
 * @Date: 2021/12/25 15:05
 * @Version 1.0
 */
public class No1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int preMax = values[0] + 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, preMax + values[i] - i);
            preMax = Math.max(preMax, values[i] + i);
        }
        return ans;
    }
}
