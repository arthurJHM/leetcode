package com.arthur.bishi.ali.day20210320;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/3/20 11:21
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

//        不知道暴力剪枝能不能过
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int max = -1;
        for (int i = 1; i < n - 1; i++) {
            for (int l = 0; l < i; l++) {
                if(a[l] <= a[i]) {
                    left.add(l);
                }
            }
            for (int r = i + 1; r < n; r++) {
                if(a[r] >= a[i]) {
                    right.add(r);
                }
            }
            for (Integer l : left) {
                for (Integer r : right) {
                    max = Math.max(b[l] + b[r] + b[i], max);
                }
            }
            left.clear();
            right.clear();
        }
        System.out.println(max);;
    }
}
