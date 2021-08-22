package com.arthur.bishi.jd0821;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 19:00
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] nums = new int[N][2];
        for (int i = 0; i < N; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(i != j && Math.abs(nums[i][0] - nums[j][0]) == Math.abs(nums[i][1] - nums[j][1])) {
                    ans++;
                }
            }
        }
        System.out.println(ans / 2);
    }
}
