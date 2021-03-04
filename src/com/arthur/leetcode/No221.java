package com.arthur.leetcode;

/**
 * @title: No221
 * @Author ArthurJi
 * @Date: 2021/3/4 19:38
 * @Version 1.0
 */
public class No221 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;
    }
}
/*221. 最大正方形
        在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。



        示例 1：


        输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        输出：4
        示例 2：


        输入：matrix = [["0","1"],["1","0"]]
        输出：1
        示例 3：

        输入：matrix = [["0"]]
        输出：0*/
/*方法二：动态规划
        方法一虽然直观，但是时间复杂度太高，有没有办法降低时间复杂度呢？

        可以使用动态规划降低时间复杂度。我们用 \textit{dp}(i, j)dp(i,j) 表示以 (i, j)(i,j) 为右下角，且只包含 11 的正方形的边长最大值。如果我们能计算出所有 \textit{dp}(i, j)dp(i,j) 的值，那么其中的最大值即为矩阵中只包含 11 的正方形的边长最大值，其平方即为最大正方形的面积。

        那么如何计算 \textit{dp}dp 中的每个元素值呢？对于每个位置 (i, j)(i,j)，检查在矩阵中该位置的值：

        如果该位置的值是 00，则 \textit{dp}(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；

        如果该位置的值是 11，则 \textit{dp}(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 \textit{dp}dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 11，状态转移方程如下：

        dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
        dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1

        如果读者对这个状态转移方程感到不解，可以参考 1277. 统计全为 1 的正方形子矩阵的官方题解，其中给出了详细的证明。

        此外，还需要考虑边界条件。如果 ii 和 jj 中至少有一个为 00，则以位置 (i, j)(i,j) 为右下角的最大正方形的边长只能是 11，因此 \textit{dp}(i, j) = 1dp(i,j)=1。

        以下用一个例子具体说明。原始矩阵如下。


        0 1 1 1 0
        1 1 1 1 0
        0 1 1 1 1
        0 1 1 1 1
        0 0 1 1 1
        对应的 \textit{dp}dp 值如下。


        0 1 1 1 0
        1 1 2 2 0
        0 1 2 3 1
        0 1 2 3 2
        0 0 1 2 3
        下图也给出了计算 \textit{dp}dp 值的过程。



        JavaC++Python3Golang

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
复杂度分析

        时间复杂度：O(mn)O(mn)，其中 mm 和 nn 是矩阵的行数和列数。需要遍历原始矩阵中的每个元素计算 \textit{dp}dp 的值。

        空间复杂度：O(mn)O(mn)，其中 mm 和 nn 是矩阵的行数和列数。创建了一个和原始矩阵大小相同的矩阵 \textit{dp}dp。由于状态转移方程中的 \textit{dp}(i, j)dp(i,j) 由其上方、左方和左上方的三个相邻位置的 \textit{dp}dp 值决定，因此可以使用两个一维数组进行状态转移，空间复杂度优化至 O(n)O(n)。

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
