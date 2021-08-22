package com.arthur.bishi.wangyi0821;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 15:18
 * @modifiedBy：
 * @version: 1.0
 */
public class No4 {
    public static void main(String[] args) {
        int[][] input = {
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 2, 1, 1},
                {0, 2, 0, 0, 1}
        };
        int[][] input1 = {
                {0}
        };
        System.out.println(new No4().minSailCost(input1));
    }

    static int[][] fang = {
            {1, 0},
            {0, 1},
    };
    static int ans = Integer.MAX_VALUE;
    static int m;
    static int n;
    static int val = 0;

    public int minSailCost(int[][] input) {
        // write code here
        m = input.length;
        n = input[0].length;
        if(input[m - 1][n - 1] == 2 || input[0][0] == 2) {
            return -1;
        }
        dfs(0, 0, input);
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans - input[0][0];
    }

    private void dfs(int i, int j, int[][] input) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }
        if (input[i][j] == 2) {
            return;
        }
        int temp = input[i][j];
        input[i][j] = 2;
        val += (2 - temp);
        if (i == m - 1 && j == n - 1) {
            ans = Integer.min(ans, val);
        }
        for (int k = 0; k < fang.length; k++) {
            dfs(i + fang[k][0], j + fang[k][1], input);
        }
        input[i][j] = temp;
        val -= (2 - temp);
    }
}
