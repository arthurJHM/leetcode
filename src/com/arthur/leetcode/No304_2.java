package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二维区域和检索 - 矩阵不可变_二刷
 * @title: No304_2
 * @Author hengmingji
 * @Date: 2022/1/1 20:01
 * @Version 1.0
 */
public class No304_2 {
    int[][] nums;

    public No304_2(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        nums = new int[height + 1][width + 1];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (nums[row2 + 1][col2 + 1]-nums[row1][col2 + 1] - nums[row2 + 1][col1] + nums[row1][col1]);
    }
}
