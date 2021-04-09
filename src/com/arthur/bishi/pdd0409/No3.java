package com.arthur.bishi.pdd0409;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: No3_1
 * @Author ArthurJi
 * @Date: 2021/4/9 16:48
 * @Version 1.0
 */
public class No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        char[] s1 = s.toCharArray();
        int m = s1.length / k;
        char[] s2 = new char[m];

        StringBuffer res = new StringBuffer();
        if (s1.length % k != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < m; i++) {
                s2[i] = s1[i];
            }
            Arrays.sort(s2);
            res.append(String.valueOf(s2));
            for (int i = s2.length - 1; i >= 0; i--) {
                for (int j = 0; j < k - 1; j++) {
                    res.append(s2[i]);
                }
            }

            System.out.println(res.toString());
        }

    }
}
