package com.arthur.leetcode;

/**
 * @title: No766
 * @Author ArthurJi
 * @Date: 2021/2/22 13:53
 * @Version 1.0
 */
public class No766 {
    public static void main(String[] args) {

    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if(matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
