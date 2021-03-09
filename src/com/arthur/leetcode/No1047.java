package com.arthur.leetcode;

import java.util.Stack;

/**
 * @title: No1047
 * @Author ArthurJi
 * @Date: 2021/3/9 9:56
 * @Version 1.0
 */
public class No1047 {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int top = -1;  //当top == -1的时候，说明现在什么都没有了
        for (int i = 0; i < s.length; i++) {
            if (top == -1 || s[i] != s[top]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }

    public String removeDuplicates_2(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty() || S.charAt(i) != stack.peek()) {
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character ch : stack) {
            ans.append(ch);
        }
        return String.valueOf(ans);
    }
}
/*

1047. 删除字符串中的所有相邻重复项
        给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

        在 S 上反复执行重复项删除操作，直到无法继续删除。

        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。



        示例：

        输入："abbaca"
        输出："ca"
        解释：
        例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
*/
