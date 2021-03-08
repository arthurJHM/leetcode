package com.arthur.leetcode;

/**
 * @title: No5_2
 * @Author ArthurJi
 * @Date: 2021/3/8 10:46
 * @Version 1.0
 */
public class No5_2 { //更快
    public static void main(String[] args) {

    }
    int ans = 0;
    String ansStr = new String();
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            huiwen(dp, s, i, i);
            huiwen(dp, s, i, i + 1);
        }

        return ansStr;
    }

    private void huiwen(boolean[][] dp, String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) ) {
            dp[i][j] = true;
            i--;
            j++;
        }
        if(ans <= (j - 1 - (i + 1) + 1)) {
            ansStr = s.substring(i + 1, j);
            ans = (j - 1 - (i + 1) + 1);
        }
    }
}
