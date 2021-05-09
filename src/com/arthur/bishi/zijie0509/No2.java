package com.arthur.bishi.zijie0509;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/5/9 19:35
 * @Version 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        long[] add = new long[n];
        char[] s = scanner.nextLine().toCharArray();
//        Stream.of(s).mapToInt(o -> Integer.parseInt(o + "")).toArray();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            for (int j = l - 1; j < r; j++) {
                add[j]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(add[i] % 2 == 1) {
                if(s[i] == '1') {
                    s[i] = '0';
                } else {
                    s[i] = '1';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(s[i]);
        }
    }
}
