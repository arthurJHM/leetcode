package com.arthur.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @title: No264
 * @Author ArthurJi
 * @Date: 2021/4/11 12:17
 * @Version 1.0
 */
public class No264 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        HashSet<Long> hashSet = new HashSet<>();
        PriorityQueue<Long> stack = new PriorityQueue<>();
        hashSet.add(1L);
        stack.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long poll = stack.poll();
            ugly = (int) poll;
            for (int factor : factors) {
                if(hashSet.add(factor * poll)) {
                    stack.add(factor * poll);
                }
            }
        }
        return ugly;
    }
}

/*264. 丑数 II
        给你一个整数 n ，请你找出并返回第 n 个 丑数 。

        丑数 就是只包含质因数 2、3 和/或 5 的正整数。



        示例 1：

        输入：n = 10
        输出：12
        解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
        示例 2：

        输入：n = 1
        输出：1
        解释：1 通常被视为丑数。*/
