package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 找到小镇的法官
 * @title: No997
 * @Author hengmingji
 * @Date: 2021/12/19 13:01
 * @Version 1.0
 */
public class No997 {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for (int[] tru : trust) {
            in[tru[1]]++;
            out[tru[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
