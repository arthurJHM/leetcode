package com.arthur.bishi.pdd0725;

import java.util.Scanner;
import java.util.zip.Deflater;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/7/25 19:01
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] num = new int[N][2];
        for (int i = 0; i < N; i++) {
            num[i][0] = scanner.nextInt();
            num[i][1] = scanner.nextInt();
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (i != j && !flag) {
                    if(pan(num[i][0], num[i][1], num[j][0], num[j][1])) {
                        flag = true;
                    }
                }
            }
        }
        if(flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean pan(int a, int b, int c, int d) {
        if(a <= c && b >= d || c <=a && d >=b) {
            return true;
        }
        return false;
    }
}
