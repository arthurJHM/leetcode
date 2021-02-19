package com.arthur.leetcode;

/**
 * @title: No62
 * @Author ArthurJi
 * @Date: 2021/2/19 20:42
 * @Version 1.0
 */
public class No62 {
    public static void main(String[] args) {
        System.out.println(new No62().uniquePaths(3, 7));
    }
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}
//简单动态规划