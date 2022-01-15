package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二进制中1的个数
 * @title: JZoffer15
 * @Author hengmingji
 * @Date: 2022/1/15 11:24
 * @Version 1.0
 */
public class JZoffer15 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
