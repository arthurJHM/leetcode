package com.arthur.leetcode;

/**
 * @title: No64
 * @Author ArthurJi
 * @Date: 2021/2/18 15:25
 * @Version 1.0
 */
public class No64 {
    public static void main(String[] args) {
        System.out.println(new No64().minPathSum(new int[][]{{1, 3, 1},{1, 5, 1},{4 ,2 , 1}}));
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[row][col];

        int temp = 0;
        for (int i = 0; i < row; i++) {
            temp += grid[i][0];
            ans[i][0] = temp;
        }

        temp = 0;
        for (int i = 0; i < col; i++) {
            temp += grid[0][i];
            ans[0][i] = temp;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                ans[i][j] = Math.min(ans[i - 1][j], ans[i][j - 1]) + grid[i][j];
            }
        }
        return ans[row - 1][col - 1];
    }
}


/*  64. 最小路径和
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

        说明：每次只能向下或者向右移动一步。

         

        示例 1：


        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        输出：7
        解释：因为路径 1→3→1→1→1 的总和最小。
        示例 2：

        输入：grid = [[1,2,3],[4,5,6]]
        输出：12*/

