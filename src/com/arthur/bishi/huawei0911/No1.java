package com.arthur.bishi.huawei0911;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/11 15:21
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
    }

    public int get(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        int[] dp2 = new int[nums.length];
        dp2[0] = nums[0];
        dp2[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < dp2.length - 1; i++) {
            dp2[i] = Integer.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        return Integer.max(dp[nums.length],dp2[nums.length - 1]);
    }
}
