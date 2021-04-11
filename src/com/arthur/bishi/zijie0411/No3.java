package com.arthur.bishi.zijie0411;

import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int m = scanner.nextInt();
            int[][] nums = new int[m][5];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 5; k++) {
                    nums[j][k] = scanner.nextInt();
                }
            }
            int maxValue = Integer.MIN_VALUE;
            int first = 0;
            int left = 0;
            for (int j = 0; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    int minTemp = Integer.MAX_VALUE;
                    for (int l = 0; l < 5; l++) {
                        minTemp = Math.min(Math.max(nums[j][l], nums[k][l]), minTemp);
                    }
                    if (minTemp > maxValue) {
                        first = j + 1;
                        left = k + 1;
                        maxValue = minTemp;
                    }
                }
            }
            System.out.println(maxValue + " " + first + " " + left);
        }
    }
}
       /* 2
        4
        5 4 3 10 1
        8 6 7 3 10
        9 5 3 10 10
        2 6 6 8 5
        6
        4 8 9 1 7
        1 9 4 3 4
        4 7 9 6 7
        2 9 4 4 6
        9 9 10 10 4
        7 2 5 9 5*/

