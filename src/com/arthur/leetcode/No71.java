package com.arthur.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 简化路径
 * @title: No71
 * @Author hengmingji
 * @Date: 2022/1/6 21:23
 * @Version 1.0
 */
public class No71 {
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        char[] chars = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; ) {
            if (chars[i] == '/' && ++i > 0) {
                continue;
            }
            int j = i + 1;
            while (j < chars.length && chars[j] != '/') {
                j++;
            }
            String substring = path.substring(i, j);
            if (substring.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if(!substring.equals(".")) {
                stack.addLast(substring);
            }
            i = j;
        }
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.removeFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
