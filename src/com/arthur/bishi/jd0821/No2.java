package com.arthur.bishi.jd0821;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/21 19:35
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int y = 0;
        int l = 0;
        int[] bili = new int[N];
        int[] yi = new int[N];
        int[] ling = new int[N];
        int[] nums = new int[N];
        Arrays.fill(bili, 1);
        String s = scanner.nextLine();
        for (int i = 0; i < N; i++) {
            nums[i] = s.charAt(i) - '0';
            if (nums[i] == 1) {
                yi[i] = ++y;
                ling[i] = l;
            } else {
                yi[i] = y;
                ling[i] = ++l;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if((ling[i] - ling[j]) * bili[j] == ling[j] && (yi[i] - yi[j]) * bili[j] == yi[j]) {
                    if(bili[i] < (bili[j] + 1)) {
                        bili[i] = bili[j] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < bili.length; i++) {
            System.out.print(bili[i]);
            if(i != bili.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
