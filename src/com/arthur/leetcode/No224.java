package com.arthur.leetcode;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.Stack;

/**
 * @title: No224
 * @Author ArthurJi
 * @Date: 2021/3/10 9:10
 * @Version 1.0
 */
public class No224 {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char[] chars = s.toCharArray();
        int temp = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (isNumber(chars[i])) {
                if (temp == -1) {
                    temp = chars[i] - '0';
                } else {
                    temp = temp * 10 + (chars[i] - '0');
                }
            } else {
                if (temp != -1) {
                    numStack.push(temp);
                    temp = -1;
                }
                if (isOP(chars[i] + "")) {
                    while (!opStack.isEmpty()) {
                        if (opStack.peek() == '(') {
                            break;
                        }
                        int num1 = numStack.pop();
                        int num2;
                        if (numStack.isEmpty()) {
                            if (opStack.peek() == '+') {
                                opStack.pop();
                                numStack.push(num1);
                            } else if (opStack.peek() == '-') {
                                opStack.pop();
                                numStack.push(-num1);
                            }
                        } else {
                            num2 = numStack.pop();
                            if (opStack.peek() == '+') {
                                opStack.pop();
                                numStack.push(num2 + num1);
                            } else if (opStack.peek() == '-') {
                                opStack.pop();
                                numStack.push(num2 - num1);
                            }
                        }
                    }
                    opStack.push(chars[i]);
                }
                if (chars[i] == '(') {
                    opStack.push(chars[i]);
                } else if (chars[i] == ')') {
                    while (opStack.peek() != '(') {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        if (opStack.peek() == '+') {
                            opStack.pop();
                            numStack.push(num2 + num1);
                        } else if (opStack.peek() == '-') {
                            opStack.pop();
                            numStack.push(num2 - num1);
                        }
                    }
                    opStack.pop();
                }
            }
        }
        if (temp != -1) {
            numStack.push(temp);
        }
        while (!opStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2;
            if (numStack.isEmpty()) {
                if (opStack.peek() == '+') {
                    opStack.pop();
                    numStack.push(num1);
                } else if (opStack.peek() == '-') {
                    opStack.pop();
                    numStack.push(-num1);
                }
            } else {
                num2 = numStack.pop();
                if (opStack.peek() == '+') {
                    opStack.pop();
                    numStack.push(num2 + num1);
                } else if (opStack.peek() == '-') {
                    opStack.pop();
                    numStack.push(num2 - num1);
                }
            }
        }
        return numStack.pop();
    }

    private boolean isOP(String aChar) {
        return aChar.equals("+") || aChar.equals("-");
    }

    private boolean isNumber(char aChar) {
        return aChar <= '9' && aChar >= '0';
    }

}

/*
224. 基本计算器
        实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。



        示例 1：

        输入：s = "1 + 1"
        输出：2
        示例 2：

        输入：s = " 2-1 + 2 "
        输出：3
        示例 3：

        输入：s = "(1+(4+5+2)-3)+(6+8)"
        输出：23

*/
/*
解法二 双栈
解法一经过了一个中间过程，先转为了后缀表达式然后进行求值。我们其实可以直接利用两个栈，边遍历边进行的，和解法一其实有些类似的。

        使用两个栈，stack0 用于存储操作数，stack1 用于存储操作符
        从左往右扫描，遇到操作数入栈 stack0
        遇到操作符时，如果当前优先级低于或等于栈顶操作符优先级，则从 stack0 弹出两个元素，从 stack1 弹出一个操作符，进行计算，将结果并压入stack0，继续与栈顶操作符的比较优先级。
        如果遇到操作符高于栈顶操作符优先级，则直接入栈 stack1
        遇到左括号，直接入栈 stack1。
        遇到右括号，则从 stack0 弹出两个元素，从 stack1 弹出一个操作符进行计算，并将结果加入到 stack0 中，重复这步直到遇到左括号
        和解法一一样，因为我们只有加法和减法，所以这个流程可以简化一下。

        第 3 条改成「遇到操作符时，则从 stack0 弹出两个元素进行计算，并压入stack0，直到栈空或者遇到左括号，最后将当前操作符压入 stack1 」

        第 4 条去掉，已经和第 3 条合并了。

        整体框架和解法一其实差不多，数字的话同样也需要累加，然后当遇到运算符或者括号的时候就将数字入栈。


public int calculate(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        int temp = -1;
        for (int i = 0; i < n; i++) {
        if (array[i] == ' ') {
        continue;
        }
        // 数字进行累加
        if (isNumber(array[i])) {
        if (temp == -1) {
        temp = array[i] - '0';
        } else {
        temp = temp * 10 + array[i] - '0';
        }
        } else {
        //将数字入栈
        if (temp != -1) {
        num.push(temp);
        temp = -1;
        }
        //遇到操作符
        if (isOperation(array[i] + "")) {
        while (!op.isEmpty()) {
        if (op.peek() == '(') {
        break;
        }
        //不停的出栈，进行运算，并将结果再次压入栈中
        int num1 = num.pop();
        int num2 = num.pop();
        if (op.pop() == '+') {
        num.push(num1 + num2);
        } else {
        num.push(num2 - num1);
        }

        }
        //当前运算符入栈
        op.push(array[i]);
        } else {
        //遇到左括号，直接入栈
        if (array[i] == '(') {
        op.push(array[i]);
        }
        //遇到右括号，不停的进行运算，直到遇到左括号
        if (array[i] == ')') {
        while (op.peek() != '(') {
        int num1 = num.pop();
        int num2 = num.pop();
        if (op.pop() == '+') {
        num.push(num1 + num2);
        } else {
        num.push(num2 - num1);
        }
        }
        op.pop();
        }

        }
        }
        }
        if (temp != -1) {
        num.push(temp);
        }
        //将栈中的其他元素继续运算
        while (!op.isEmpty()) {
        int num1 = num.pop();
        int num2 = num.pop();
        if (op.pop() == '+') {
        num.push(num1 + num2);
        } else {
        num.push(num2 - num1);
        }
        }
        return num.pop();
        }

private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
        }

private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
        }
        有一点需要注意，就是算减法的时候，是 num2 - num1，因为我们最初压栈的时候，被减数先压入栈中，然后减数再压栈。出栈的时候，先出来的是减数，然后才是被减数。

        作者：windliang
        链接：https://leetcode-cn.com/problems/basic-calculator/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--47/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
