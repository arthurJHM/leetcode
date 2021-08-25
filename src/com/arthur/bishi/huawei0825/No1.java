package com.arthur.bishi.huawei0825;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/25 19:31
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + nums[i - 1][j - 1] -
                        sum[i - 1][j - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        int s = cal(sum, i, j, k, l);
                        max = Math.max(max, s);
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int cal(int[][] sum, int i, int j, int k, int l) {
        return sum[k + 1][l + 1] - sum[k + 1][j] - sum[i][l + 1] + sum[i][j];
    }
}
