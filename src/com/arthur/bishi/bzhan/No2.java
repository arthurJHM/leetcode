package com.arthur.bishi.bzhan;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/13 18:58
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            if (M == -1 && N == -1) {
                return;
            }
            int[][] nums = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            int l = 0;
            int r = nums[0].length - 1;
            int t = 0;
            int b = nums.length - 1;
            int x = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while (true) {
                for (int i = l; i <= r; i++) {
                    res[x++] = nums[t][i];
                }
                if(++t > b) break;
                for (int i = t; i <= b; i++) {
                    res[x++] = nums[i][r];
                }
                if(l > --r) break;
                for (int i = r; i >= l; i--) {
                    res[x++] = nums[b][i];
                }
                if(t > --b) break;
                for (int i = b; i >= t; i--) {
                    res[x++] = nums[i][l];
                }
                if(++l > r) break;
            }
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
                if(i == res.length - 1) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            }
        }
    }
}
