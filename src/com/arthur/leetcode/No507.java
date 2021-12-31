package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 完美数
 * @title: No507
 * @Author hengmingji
 * @Date: 2021/12/31 20:31
 * @Version 1.0
 */
public class No507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int n = (int) Math.sqrt(num);
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        sum += 1;
        return num == sum;
    }
}
