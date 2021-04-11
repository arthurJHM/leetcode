package com.arthur.bishi.meituan0411;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @title: No5
 * @Author ArthurJi
 * @Date: 2021/4/11 11:35
 * @Version 1.0
 */
public class No5 {
    public static void main(String[] args) {
        long[] money = new long[7];
        money[1] = 1222;
        money[2] = money[1] * 2 + 7890;
        money[3] = money[2] * 3 + 7890 * 2;
        money[4] = money[3] * 4 + 7890 * 3;
        money[5] = money[4] * 5 + 7890 * 4;
        money[6] = money[5] * 6 + 7890 * 5;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[7];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            nums[b] += a;
        }
        int target = scanner.nextInt();

        long ans = target * money[6];
        for (int i = 1; i <= 6; i++) {
            ans -= money[i] * nums[i];
        }
        System.out.println(ans);
    }
}
