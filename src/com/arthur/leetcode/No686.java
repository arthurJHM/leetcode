package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 重复叠加字符串匹配
 * @title: No686
 * @Author hengmingji
 * @Date: 2021/12/22 10:26
 * @Version 1.0
 */
public class No686 {
    public int repeatedStringMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        String temp = a;
        int count = 1;
        while (count <= (n / m + 2)) {
            if(a.contains(b))  {
                return count;
            }
            a += temp;
            count++;
        }
        return -1;
    }
}
