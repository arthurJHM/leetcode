package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @title: No204_2
 * @Author ArthurJi
 * @Date: 2021/3/22 11:48
 * @Version 1.0
 */
public class No204_2 {//反而时间多了，笑死我了，，，，，
    static boolean[] isPrime = new boolean[5000001];

    static {
        Arrays.fill(isPrime, true);
        for (int i = 2; i < 5000001; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < 5000001; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int countPrimes(int n) {

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
            }
        }
        return ans;
    }
}
