package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 不同路径
 * @title: JZoffer62
 * @Author hengmingji
 * @Date: 2022/1/2 16:16
 * @Version 1.0
 */
public class No62_2 {
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m + 1][n + 1];
        nums[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 || j != 1) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[m][n];
    }
}
