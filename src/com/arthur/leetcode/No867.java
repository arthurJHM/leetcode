package com.arthur.leetcode;

/**
 * @title: No867
 * @Author ArthurJi
 * @Date: 2021/2/25 11:49
 * @Version 1.0
 */
public class No867 {
    public static void main(String[] args) {

    }
    public int[][] transpose(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}
