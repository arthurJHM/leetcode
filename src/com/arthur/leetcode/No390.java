package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 消除游戏
 * @title: No390
 * @Author hengmingji
 * @Date: 2022/1/2 15:49
 * @Version 1.0
 */
public class No390 {
    public int lastRemaining(int n) {
        int head = 1;
        boolean left = true;
        int step = 1;
        while (n > 1) {
            if (left || n % 2 != 0) {
                head += step;
            }
            step = step * 2;
            n /= 2;
            left = !left;
        }
        return head;
    }
}
