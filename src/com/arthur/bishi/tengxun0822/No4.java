package com.arthur.bishi.tengxun0822;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/22 21:20
 * @modifiedBy：
 * @version: 1.0
 */
public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < k - n; i++) {
            strings.add(s.substring(i, i + n));
        }
        strings.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println();
    }
}
