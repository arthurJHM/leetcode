package com.arthur.bishi.jingdong0410;

import java.util.Scanner;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/4/10 19:30
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] == nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], Math.max(dp[j][0] + 1, dp[j][1] + 1));
                    dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0] + 1, dp[j][1] + 1));
                } else {
                    dp[i][0] = Math.max(dp[i][0], Math.max(dp[j][0], dp[j][1]));
                    dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0], dp[j][1]));
                }
            }
        }
        System.out.println(Math.max(dp[n - 1][0], dp[n -1][1]));
    }

}
