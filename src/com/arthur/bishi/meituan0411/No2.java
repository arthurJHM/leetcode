package com.arthur.bishi.meituan0411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/4/11 10:20
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] N = new int[n];
        int[] M = new int[m];
        for (int i = 0; i < n; i++) {
            N[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            M[i] = in.nextInt();
        }
        Arrays.sort(M);
        Arrays.sort(N);
        int res = 0;
        int ans = 0;
        if(M[M.length - 1] > N[N.length - 1]) {
            for (int i = 0; i < m; i++) {
                if(N[N.length - 1] < M[i]) {
                    ans = i;
                    break;
                }
            }
            res = (M.length - ans) * 2;
        }
        if(M[M.length - 1] <= N[N.length - 1]) {
            res = m - n;
        }
        System.out.println(res);
    }
}
