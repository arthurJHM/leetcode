package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 求1+2+…+n
 * @title: JZoffer64
 * @Author hengmingji
 * @Date: 2022/1/8 23:35
 * @Version 1.0
 */
public class JZoffer64 {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
