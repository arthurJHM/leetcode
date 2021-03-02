package com.arthur.leetcode;

/**
 * @title: No304
 * @Author ArthurJi
 * @Date: 2021/3/2 10:55
 * @Version 1.0
 */
public class No304 {
    public static void main(String[] args) {

    }
    int[][] MatrixSum;
    int row;
    int col;
    public No304(int[][] matrix) {
        row = matrix.length;
        if(row != 0) {
            col = matrix[0].length;
        } else {
            col = 0;
        }
        MatrixSum = new int[row + 1][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                MatrixSum[i + 1][j + 1] = MatrixSum[i][j + 1] + MatrixSum[i + 1][j] - MatrixSum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return MatrixSum[row2 + 1][col2 + 1] - MatrixSum[row2 + 1][col1] - MatrixSum[row1][col2 + 1]  + MatrixSum[row1][col1];
    }
}
