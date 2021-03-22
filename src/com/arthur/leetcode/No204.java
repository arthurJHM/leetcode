package com.arthur.leetcode;

import java.util.Arrays;
import java.util.concurrent.CountedCompleter;
import java.util.zip.CheckedOutputStream;

/**
 * @title: No204
 * @Author ArthurJi
 * @Date: 2021/3/22 11:20
 * @Version 1.0
 */
public class No204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
            }
        }
        return ans;
    }
}

/*204. 计数质数
        统计所有小于非负整数 n 的质数的数量。



        示例 1：

        输入：n = 10
        输出：4
        解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
        示例 2：

        输入：n = 0
        输出：0
        示例 3：

        输入：n = 1
        输出：0*/
