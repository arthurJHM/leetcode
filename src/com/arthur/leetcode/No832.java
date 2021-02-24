package com.arthur.leetcode;

/**
 * @title: No832
 * @Author ArthurJi
 * @Date: 2021/2/24 13:45
 * @Version 1.0
 */
public class No832 {
    public static void main(String[] args) {

    }
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = A[i][col - j - 1] ^ 1;
            }
        }
        return ans;
    }
}
