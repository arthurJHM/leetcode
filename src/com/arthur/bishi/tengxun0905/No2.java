package com.arthur.bishi.tengxun0905;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/5 18:33
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    static HashMap<Integer, Integer> maps = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = count(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b[i] = count(scanner.nextInt());
        }
        Arrays.sort(a, (o1, o2) -> {
            return o2 - o1;
        });
        Arrays.sort(b);
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (j >= 0) {
            if (a[i] <= b[j]) {
                j--;
            } else {
                ans++;
                i++;
                j--;
            }
        }
        System.out.println(ans);
    }

    private static Integer count(int num) {
        if (maps.containsKey(num)) {
            return maps.get(num);
        }
        if (num == 1) {
            maps.put(1, 1);
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        maps.put(num, count);
        return count;
    }
}
