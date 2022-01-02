package com.arthur.leetcode;

import org.omg.CORBA.OBJECT_NOT_EXIST;

/**
 * @program: leetcode
 * @description: 不同路径 II
 * @title: JZoffer63_2
 * @Author hengmingji
 * @Date: 2022/1/2 16:23
 * @Version 1.0
 */
public class No63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] nums = new int[height + 1][width + 1];
        if (obstacleGrid[0][0] == 1) {
            nums[1][1] = 0;
        } else {
            nums[1][1] = 1;
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i != 1 || j != 1) && obstacleGrid[i - 1][j - 1] == 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[height][width];
    }
}
