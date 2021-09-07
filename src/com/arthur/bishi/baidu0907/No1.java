package com.arthur.bishi.baidu0907;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/7 19:01
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int X = K * N;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(nums[i / K][j / K]);
                if(j != X - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
