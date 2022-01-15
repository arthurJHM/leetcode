package com.arthur.leetcode;

import javafx.scene.input.Mnemonic;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 顺时针打印矩阵
 * @title: JZoffer29
 * @Author hengmingji
 * @Date: 2022/1/15 15:27
 * @Version 1.0
 */
public class JZoffer29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int[] ans = new int[matrix.length * matrix[0].length];
        int n = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans[n++] = matrix[top][i];
            }
            if (++top > down) {
                break;
            }
            for (int i = top; i <= down; i++) {
                ans[n++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans[n++] = matrix[down][i];
            }
            if (--down < top) {
                break;
            }
            for (int i = down; i >= top; i--) {
                ans[n++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
