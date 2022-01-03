package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 最大正方形_二刷
 * @title: No221_2
 * @Author hengmingji
 * @Date: 2022/1/3 15:24
 * @Version 1.0
 */
public class No221_2 {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height + 1][width +1];
        int ans = 0;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i- 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;
    }
}
