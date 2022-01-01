package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 矩阵区域和
 * @title: No1314
 * @Author hengmingji
 * @Date: 2022/1/1 19:03
 * @Version 1.0
 */
public class No1314 {
    public static void main(String[] args) {
        new No1314().matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] sum = new int[height + 1][width + 1];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ans = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int maxX = Math.min(height, i+k+1);
                int minX = Math.max(0, i - k);
                int maxY = Math.min(width, j + k  +1);
                int minY = Math.max(0, j - k);
                ans[i][j] = sum[maxX][maxY] - sum[maxX][minY] - sum[minX][maxY] + sum[minX][minY];
            }
        }
        return ans;
    }
}
