package com.arthur.leetcode;

/**
 * @title: No583
 * @Author ArthurJi
 * @Date: 2021/3/24 11:39
 * @Version 1.0
 */
public class No583 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }
}
/*
583. 两个字符串的删除操作
        给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。



        示例：

        输入: "sea", "eat"
        输出: 2
        解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"


        提示：

        给定单词的长度不超过500。
        给定单词中的字符只含有小写字母。
*/
