package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 最小路径和_二刷
 * @title: No64_2
 * @Author hengmingji
 * @Date: 2022/1/3 15:20
 * @Version 1.0
 */
public class No64_2 {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 || j != 0) {
                    if (i == 0) {
                        grid[0][j] += grid[0][j - 1];
                    } else if (j == 0) {
                        grid[i][0] += grid[i - 1][0];
                    } else {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
