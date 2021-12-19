package com.arthur.leetcode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 包含min函数的栈
 * @title: JZoffer30
 * @Author hengmingji
 * @Date: 2021/12/18 15:28
 * @Version 1.0
 */
public class JZoffer30 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stackmin = new Stack<Integer>();

    /**
     * initialize your data structure here.
     */
    public JZoffer30() {

    }

    public void push(int x) {
        stack1.push(x);
        if (stackmin.isEmpty() || x < stackmin.peek()) {
            stackmin.push(x);
        } else {
            stackmin.push(stackmin.peek());
        }
    }

    public void pop() {
       stack1.pop();
       stackmin.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stackmin.peek();
    }
}
