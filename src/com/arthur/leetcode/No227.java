package com.arthur.leetcode;

import javax.xml.stream.events.Characters;
import java.util.Stack;

/**
 * @title: No227
 * @Author ArthurJi
 * @Date: 2021/3/11 9:16
 * @Version 1.0
 */
public class No227 {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        int len = s.length();
        int numTemp = 0;
        char preOp = '+';
        Stack<Integer> opStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                numTemp = numTemp * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preOp) {
                    case '+':
                        opStack.push(numTemp);
                        break;
                    case '-':
                        opStack.push(-numTemp);
                        break;
                    case '*':
                        opStack.push(opStack.pop() * numTemp);
                        break;
                    default:
                        opStack.push(opStack.pop() / numTemp);
                }
                preOp = s.charAt(i);
                numTemp = 0;
            }
        }
        int ans = 0;
        while (!opStack.isEmpty()) {
            ans += opStack.pop();
        }
        return ans;
    }
}
/*

227. 基本计算器 II
        给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

        整数除法仅保留整数部分。



        示例 1：

        输入：s = "3+2*2"
        输出：7
        示例 2：

        输入：s = " 3/2 "
        输出：1
        示例 3：

        输入：s = " 3+5 / 2 "
        输出：5
*/
