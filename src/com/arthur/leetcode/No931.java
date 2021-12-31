package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 下降路径最小和
 * @title: No931
 * @Author hengmingji
 * @Date: 2021/12/31 22:29
 * @Version 1.0
 */
public class No931 {
    public int minFallingPathSum(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][0], matrix[i - 1][1]) + matrix[i][j];
                } else if (j == width - 1) {
                    matrix[i][j] = Math.min(matrix[i - 1][width - 1], matrix[i - 1][width - 2]) + matrix[i][j];
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]), matrix[i - 1][j + 1]) + matrix[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            ans = Math.min(ans, matrix[height - 1][i]);
        }
        return ans;
    }
}
