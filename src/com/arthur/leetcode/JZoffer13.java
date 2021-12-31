package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 机器人的运动范围
 * @title: JZoffer13
 * @Author hengmingji
 * @Date: 2021/12/30 19:54
 * @Version 1.0
 */
public class JZoffer13 {
    int ans = 0;
    int n;
    int m;

    public int movingCount(int m, int n, int k) {
        boolean[][] check = new boolean[m][n];
        this.n = n;
        this.m = m;
        dfs(check, 0, 0, k);
        return ans;
    }

    private void dfs(boolean[][] check, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n  || check[i][j] || !check(i, j, k)) {
            return;
        }
        check[i][j] = true;
        ans++;
        dfs(check, i + 1, j, k);
        dfs(check, i - 1, j, k);
        dfs(check, i, j + 1, k);
        dfs(check, i, j - 1, k);
    }

    private boolean check(int i, int j, int k) {
        int ans = 0;
        while (i > 0) {
            ans += i % 10;
            i /= 10;
        }
        while (j > 0) {
            ans += j % 10;
            j /= 10;
        }
        if (ans <= k) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new JZoffer13().movingCount(1,2,1);
    }
}
