package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: II. 左旋转字符串
 * @title: ZJofffer58
 * @Author hengmingji
 * @Date: 2021/12/19 18:39
 * @Version 1.0
 */
public class JZofffer58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
