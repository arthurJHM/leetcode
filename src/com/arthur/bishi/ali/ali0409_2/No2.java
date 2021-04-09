package com.arthur.bishi.ali.ali0409_2;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/4/9 18:56
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < k; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int swap;
            while (left < right) {
                swap = nums[left];
                nums[left] = nums[right];
                nums[right] = swap;
                left++;
                right--;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }
    }
}
