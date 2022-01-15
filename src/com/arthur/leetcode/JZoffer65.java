package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 不用加减乘除做加法
 * @title: JZoffer65
 * @Author hengmingji
 * @Date: 2022/1/15 11:34
 * @Version 1.0
 */
public class JZoffer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a =  a ^ b;
            b = c;
        }
        return a;
    }
}
