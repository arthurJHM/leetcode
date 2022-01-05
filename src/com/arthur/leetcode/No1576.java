package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 替换所有的问号
 * @title: No1576
 * @Author hengmingji
 * @Date: 2022/1/5 21:09
 * @Version 1.0
 */
public class No1576 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 3 && chars[i] == '?'; j++) {
                boolean flag = true;
                if (i - 1 >= 0 && chars[i - 1] == j + 'a') {
                    flag = false;
                }
                if (i + 1 < length && chars[i + 1] == j + 'a') {
                    flag = false;
                }
                if(flag) {
                    chars[i] = (char) (j + 'a');
                    break;
                }
            }
        }
        return String.valueOf(chars);
    }
}
