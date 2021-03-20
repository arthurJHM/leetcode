package com.arthur.bishi.ali.day20210320;

import sun.security.krb5.Asn1Exception;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/3/20 10:26
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[i] = (int) Math.abs(nums[i] - Math.pow(Math.round(Math.sqrt(nums[i])), 2));
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += nums[i];
        }
        System.out.printf(String.valueOf(ans));
    }

}
