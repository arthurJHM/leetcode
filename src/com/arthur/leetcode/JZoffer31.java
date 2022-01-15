package com.arthur.leetcode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 栈的压入、弹出序列
 * @title: JZoffer31
 * @Author hengmingji
 * @Date: 2022/1/15 16:03
 * @Version 1.0
 */
public class JZoffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int n : pushed) {
            stack.push(n);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
