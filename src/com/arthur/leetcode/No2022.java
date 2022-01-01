package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 将一维数组转变成二维数组
 * @title: No2022
 * @Author hengmingji
 * @Date: 2022/1/1 18:28
 * @Version 1.0
 */
public class No2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m * n) {
            return new int[][]{};
        }
        int[][] num = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = original[k++];
            }
        }
        return num;
    }
}
