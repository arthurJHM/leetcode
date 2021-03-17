package com.arthur.leetcode;

/**
 * @title: No115
 * @Author ArthurJi
 * @Date: 2021/3/17 9:16
 * @Version 1.0
 */
public class No115 {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
//        引入了空串
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            //0是t匹配串 对于所有的的没有匹配串的情况，都为1；  空字符串随便匹配
            dp[i][0] = 1;
        }
        //dp[i][j] 定义的是，t中j  s中i 最多能构成的组合
        for (int j = 1; j <= t.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];

    }
}
/*115. 不同的子序列
        给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

        字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

        题目数据保证答案符合 32 位带符号整数范围。



        示例 1：

        输入：s = "rabbbit", t = "rabbit"
        输出：3
        解释：
        如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
        (上箭头符号 ^ 表示选取的字母)
        rabbbit
        ^^^^ ^^
        rabbbit
        ^^ ^^^^
        rabbbit
        ^^^ ^^^
        示例 2：

        输入：s = "babgbag", t = "bag"
        输出：5
        解释：
        如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
        (上箭头符号 ^ 表示选取的字母)
        babgbag
        ^^ ^
        babgbag
        ^^    ^
        babgbag
        ^    ^^
        babgbag
        ^  ^^
        babgbag
        ^^^


        提示：

        0 <= s.length, t.length <= 1000
        s 和 t 由英文字母组成
        通过次数26,246提交次数51,641*/
/*
python题解--一看就懂的分析
        铁柱锈死了
        发布于 2020-08-12
        1.8k
        解题思路
        image.png

        关于这个题目，我看了很多的题解，不知道是我的理解程度不够还是大佬们没讲清楚，我站在大佬的肩膀上分析下这个问题

        首先说下关于优化的问题，优化的基础是看能不能使用一维的滚动数组来表示二维的数组，前提是你得能写出二维的！！！，这个题目可以使用滚动数组，我这里没写，大家自行写下，这个不难

        ！！！！！！！！！！！！！！！！！重点来了！！！！！！！！！！！！！！！！！！

        我相信有一部分人不懂是 当s[j] == t[i] 时的情况的分析

        假设我们有字符串 s = abcc 和 字符串 abc

        设定dp[i][j]为使用s的前i个字符能够最多组成多少个t的前j个字符

        当s[j] == t[i] 时：此时假设j=3，i=2，需要比较的是 abcc 中含有多少个abc

        当考虑使用第i个元素时，即我们让 abcc 中的最后一个c 和abc最后一个c匹配上，这时我们需要看的是 abc中含有多少个 ab ,对应dp[i-1][j-1]
        2.当不考虑使用第i个元素时，我们需要看的是 abc 中含有多少个abc ,对应dp[i][j-1]

        转移方程为dp[i][j] = dp[i-1][j-1] + dp[i][j-1]

        当s[j] ！= t[i] 时，此时假设j=3，i=2

        只有一种情况，只需要看的是 abc 中含有多少个abc即可，对应dp[i][j-1]

        转移方程为dp[i][j] = dp[i][j-1]

        代码

class Solution:
        def numDistinct(self, s: str, t: str) -> int:

        dp = [[0]*(len(s) +1) for _ in range(len(t)+1)]

        for i in range(len(s)+1):
        dp[0][i] = 1

        for i in range(1,len(t)+1):
        for j in range(1,len(s)+1):
        if t[i-1] == s[j-1]:
        dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
        else:
        dp[i][j] = dp[i][j-1]

        return dp[-1][-1]
*/

