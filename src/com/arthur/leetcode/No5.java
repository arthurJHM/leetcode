package com.arthur.leetcode;

/**
 * @title: No5
 * @Author ArthurJi
 * @Date: 2021/3/8 10:35
 * @Version 1.0
 */
public class No5 {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            huiwen(dp, s, i, i);
            huiwen(dp, s, i, i + 1);
        }
        int ans = 0;
        String ansStr = new String();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(dp[i][j] && ans < (j - i)) {
                    ans = j - i;
                    ansStr = s.substring(i, j + 1);
                }
            }
        }
        return ansStr;
    }

    private void huiwen(boolean[][] dp, String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) ) {
            dp[i][j] = true;
            i--;
            j++;
        }
    }
}
/*5. 最长回文子串
        给你一个字符串 s，找到 s 中最长的回文子串。



        示例 1：

        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
        示例 2：

        输入：s = "cbbd"
        输出："bb"
        示例 3：

        输入：s = "a"
        输出："a"
        示例 4：

        输入：s = "ac"
        输出："a"*/

