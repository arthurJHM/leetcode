package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: I. 剪绳子
 * @title: JZoffer14_1
 * @Author hengmingji
 * @Date: 2022/1/15 14:39
 * @Version 1.0
 */
public class JZoffer14_1 {
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if(b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        if(b == 2) {
            return (int) (Math.pow(3,a)*2);
        }
        return (int) Math.pow(3,a);
    }
}
