package com.arthur.bishi.xiecheng0909;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/9 19:29
 * @modifiedBy：
 * @version: 1.0
 */
public class No3 {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nn = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split("0");
        int[][] count = new int[N][2];
        for (int i = 0; i < N; i++) {
            count[i][0] = scanner.nextInt();
            count[i][1] = scanner.nextInt();
        }
        int ans = 0;
        for (int k = 0; k < split.length; k++) {
            ans += get(split[k], count);
        }
        System.out.println(ans);
    }

    private static int get(String str, int[][] count) {
        int n = str.length();
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i - 1) != '0') {
                for (int j = 0; j < count.length; j++) {
                    int temp = count[j][0];
                    if (i - temp >= 0) {
                        dp[i] = Integer.max(dp[i - temp] + count[j][1], dp[i]);
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ans = Integer.max(ans, dp[i]);
        }
        map.put(n, ans);
        return ans;
    }
}
