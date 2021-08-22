package com.arthur.bishi.xiaohongshu0821;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 10:45
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    static int N;
    static int[][] fang = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    static char[][] nums;
    static int ci = 0;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        nums = new char[N][N];
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '#') ci++;
                nums[i][j] = s.charAt(j);
            }
        }
        ci = N * N - ci;
        dfs(0, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int i, int j, int count) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }
        if (nums[i][j] == '#') return;
        count++;
        if (count == ci && i == N - 1) {
            ans++;
        }
        nums[i][j] = '#';
        for (int k = 0; k < fang.length; k++) {
            dfs(i + fang[k][0], j + fang[k][1], count);
        }
        nums[i][j] = '.';
        count--;
    }
}
