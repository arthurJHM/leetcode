package com.arthur.leetcode;

/**
 * @title: No240_2
 * @Author ArthurJi
 * @Date: 2021/3/4 21:16
 * @Version 1.0
 */
public class No240_2 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                i++;
            } else if(matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}
