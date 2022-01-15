package com.arthur.leetcode;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 圆圈中最后剩下的数字
 * @title: JZoffer62
 * @Author hengmingji
 * @Date: 2022/1/15 15:07
 * @Version 1.0
 */
public class JZoffer62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
