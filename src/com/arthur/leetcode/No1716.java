package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 计算力扣银行的钱
 * @title: No1716
 * @Author hengmingji
 * @Date: 2022/1/15 10:44
 * @Version 1.0
 */
public class No1716 {
    public int totalMoney(int n) {
        int count = n / 7;
        int ans = (28 + ((count - 1) * 7 + 28)) * count / 2;
        int other = n % 7;
        ans += (count + 1 + other + count) * other / 2;
        return ans;
    }
}
