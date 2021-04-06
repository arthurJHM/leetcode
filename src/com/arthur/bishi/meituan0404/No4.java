package com.arthur.bishi.meituan0404;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title: No4
 * @Author ArthurJi
 * @Date: 2021/4/4 10:12
 * @Version 1.0
 */
public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] table = new int[n][n];
        int[][] ans = new int[n][n];
        ArrayList<int[]>[] map = new ArrayList[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
                if (map[table[i][j]] == null) {
                    map[table[i][j]] = new ArrayList<int[]>();
                }
                map[table[i][j]].add(new int[]{i, j});
            }
        }
        if(map[1] == null) {
            System.out.println(-1);
            return;
        }
        for (int i = 2; i <= k; i++) {
            if (map[i] == null) {
                System.out.println(-1);
                return;
            }
            for (int[] cur : map[i]) {
                int min = Integer.MAX_VALUE;
                for (int[] pre : map[i - 1]) {
                    min = Math.min(min, Math.abs(cur[0] - pre[0]) + Math.abs(cur[1] - pre[1]));
                }
                ans[cur[0]][cur[1]] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int[] m : map[k]) {
            res = Math.min(ans[m[0]][m[1]], res);
        }
        System.out.println(res);
    }
}
