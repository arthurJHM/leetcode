package com.arthur.bishi.meituan0411;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: No4
 * @Author ArthurJi
 * @Date: 2021/4/11 10:23
 * @Version 1.0
 */
public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    String sub = s.substring(i, j + 1);
                    if(isImpor(sub)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isImpor(String sub) {

        int[] counts = new int[26];
        char[] chars = sub.toCharArray();
        for (char ch : chars) {
            counts[ch - 'a']++;
        }
        return Arrays.stream(counts).max().getAsInt() > sub.length() / 2.0;
    }
}
