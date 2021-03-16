package com.arthur.leetcode;

import sun.plugin2.os.windows.FLASHWINFO;

/**
 * @title: No59
 * @Author ArthurJi
 * @Date: 2021/3/16 9:42
 * @Version 1.0
 */
public class No59 {
    public static void main(String[] args) {
        new No59().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int down  = n - 1;
        int right = n - 1;
        int left = 0;
        int top = 0;
        int[][] ans = new int[n][n];

        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            if(top++ == down) break;

            for (int i = top; i <= down; i++) {
                ans[i][right] = num++;
            }
            if(right-- == left) break;

            for (int i = right; i >= left; i--) {
                ans[down][i] = num++;
            }
            if(down-- == top) break;

            for (int i = down; i >= top; i--) {
                ans[i][left] = num++;
            }
            if(left++ == left) break;

        }
        return ans;
    }
}
/*
59. 螺旋矩阵 II
        给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



        示例 1：


        输入：n = 3
        输出：[[1,2,3],[8,9,4],[7,6,5]]
        示例 2：

        输入：n = 1
        输出：[[1]]

*/
