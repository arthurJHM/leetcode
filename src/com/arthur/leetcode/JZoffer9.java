package com.arthur.leetcode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 用两个栈实现队列
 * @title: jzoffer9
 * @Author hengmingji
 * @Date: 2021/12/18 15:19
 * @Version 1.0
 */
public class JZoffer9 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public JZoffer9() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
