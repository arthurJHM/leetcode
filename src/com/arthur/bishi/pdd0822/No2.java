package com.arthur.bishi.pdd0822;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/22 19:01
 * @modifiedBy：
 * @version: 1.0
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < T; i++) {
            int P = scanner.nextInt();
            int Q = scanner.nextInt();
            System.out.println(dfs(map, P, Q, 0));
            map.clear();
        }
    }

    private static int dfs(HashMap<Integer, Integer> map, int p, int q, int deep) {
        if (q == p) {
            return 0;
        }
        if (p < 1 || p > 200000) {
            return Integer.MAX_VALUE / 2;
        }

        if (map.get(p) != null) {
            return map.get(p);
        }
        if(deep > 100) {
            return Integer.MAX_VALUE / 2;
        }
        int value = Integer.min(Integer.min(Integer.min(dfs(map, p - 2, q, deep + 1),
                dfs(map, p - 1, q, deep + 1)),
                dfs(map, p + 1, q, deep + 1)),
                dfs(map, p * 2, q, deep + 1)) + 1;
        map.put(p, value);
        return value;
    }
}
