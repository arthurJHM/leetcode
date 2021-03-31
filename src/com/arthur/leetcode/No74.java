package com.arthur.leetcode;

/**
 * @title: No74
 * @Author ArthurJi
 * @Date: 2021/3/30 14:26
 * @Version 1.0
 */
public class No74 {
    public static void main(String[] args) {
        new No74().searchMatrix(new int[][]{{1, 3, 7, 5}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while (i < matrix.length && matrix[i][matrix[0].length - 1] <= target) {
            if (matrix[i++][matrix[0].length - 1] == target) {
                return true;
            }
        }
        int j = 0;
        while (i < matrix.length && matrix[i][j] <= target) {
            if (matrix[i][j++] == target) {
                return true;
            }
        }
        return false;
    }
}
/*
74. 搜索二维矩阵
        编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。


        示例 1：


        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        输出：true
        示例 2：


        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        输出：false


        提示：

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -104 <= matrix[i][j], target <= 104*/
