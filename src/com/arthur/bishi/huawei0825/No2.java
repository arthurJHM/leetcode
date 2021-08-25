package com.arthur.bishi.huawei0825;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/25 19:32
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    static int row;
    static int col;
    static int ans = Integer.MAX_VALUE;
    static int[][] map;
    static int fang[][] = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        dfs(0, 0, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static void dfs(int i, int j, int deep) {
        if (i >= row || i < 0 || j >= col || j < 0) {
            return;
        }
        if (map[i][j] - deep < 0) {
            return;
        }
        if(deep > ans) {
            return;
        }
        int temp = map[i][j];
        map[i][j] = -1;
        if (i == row - 1 && j == col - 1) {
            ans = Integer.min(deep, ans);
            map[i][j] = temp;
            return;
        }
        for (int k = 0; k < fang.length; k++) {
            dfs(i + fang[k][0], j + fang[k][1], deep + 1);
        }
        map[i][j] = temp;
    }
}
