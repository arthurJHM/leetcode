package com.arthur.bishi.wangyi0821;

import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 14:32
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        int M = scanner.nextInt();

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] <= M) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
