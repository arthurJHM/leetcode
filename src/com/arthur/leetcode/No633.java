package com.arthur.leetcode;

/**
 * @title: No633
 * @Author ArthurJi
 * @Date: 2021/4/28 14:16
 * @Version 1.0
 */
public class No633 {
    public static void main(String[] args) {
        System.out.println(new No633().judgeSquareSum(11));
    }

    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        for (int i = 0; i <= n; i++) {
            int b = (int) Math.sqrt(c - i * i);
            if (i * i + b * b == c) {
                return true;
            }
        }
        return false;
    }
}
/*
633. 平方数之和
        给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。



        示例 1：

        输入：c = 5
        输出：true
        解释：1 * 1 + 2 * 2 = 5
        示例 2：

        输入：c = 3
        输出：false
        示例 3：

        输入：c = 4
        输出：true
        示例 4：

        输入：c = 2
        输出：true
        示例 5：

        输入：c = 1
        输出：true*/
