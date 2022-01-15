package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 数值的整数次方
 * @title: JZoffer16
 * @Author hengmingji
 * @Date: 2022/1/14 17:31
 * @Version 1.0
 */
public class JZoffer16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double ans = 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if (b % 2 == 1) {
                ans *= x;
            }
            x *= x;
            b /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new JZoffer16().myPow(2, 10));
    }
}
