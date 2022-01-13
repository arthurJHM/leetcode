package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 累加数
 * @title: No306
 * @Author hengmingji
 * @Date: 2022/1/10 10:15
 * @Version 1.0
 */
public class No306 {
    public boolean isAdditiveNumber(String num) {
        int i = 0;
        int j = 1;
        int num1 = Integer.valueOf(num.substring(i, j));
        int num2 = Integer.valueOf(num.substring(j, j + 1));
        int k = 2;
        int len = String.valueOf(num1 + num2).length();
        while (k + len < num.length()) {
            if (num1 + num2 != Integer.valueOf(num.substring(k, k + len))) {
                return false;
            }
            i = j;
            j = k;
            k = k + len;
            num1 = Integer.valueOf(num.substring(i,j));
            num2 = Integer.valueOf(num.substring(j,k));
            len = String.valueOf(num1 + num2).length();
        }
        return true;
    }
}
