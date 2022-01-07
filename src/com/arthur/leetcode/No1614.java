package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 括号的最大嵌套深度
 * @title: No1614
 * @Author hengmingji
 * @Date: 2022/1/7 11:51
 * @Version 1.0
 */
public class No1614 {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else if(s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
