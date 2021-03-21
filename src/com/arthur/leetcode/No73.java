package com.arthur.leetcode;

import java.util.ArrayList;

/**
 * @title: No73
 * @Author ArthurJi
 * @Date: 2021/3/21 9:50
 * @Version 1.0
 */
public class No73 {
    public static void main(String[] args) {


    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> cols = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer r : rows) {
            for (int i = col - 1; i >= 0; i--) {
                matrix[r][i] = 0;
            }
        }
        for (Integer c : cols) {
            for (int i = row - 1; i >= 0; i--) {
                matrix[i][c] = 0;
            }
        }

    }
}
/*73. 矩阵置零
        给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

        进阶：

        一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
        一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
        你能想出一个仅使用常量空间的解决方案吗？


        示例 1：


        输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        输出：[[1,0,1],[0,0,0],[1,0,1]]
        示例 2：


        输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]*/
