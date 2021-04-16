package com.arthur.leetcode;

/**
 * @title: No87
 * @Author ArthurJi
 * @Date: 2021/4/16 12:43
 * @Version 1.0
 */
public class No87 {
    public static void main(String[] args) {

    }

    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        boolean[][][] dp = new boolean[len1][len1][len1 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j][1] = str1[i] == str2[j];
            }
        }

        for (int len = 2; len <= len1; len++) {
            for (int i = 0; i <= len1 - len; i++) {
                for (int j = 0; j <= len1 - len; j++) {
                    for (int k = 0; k < len; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len1];

    }

}

/*87. 扰乱字符串
        使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
        如果字符串的长度为 1 ，算法停止
        如果字符串的长度 > 1 ，执行下述步骤：
        在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
        随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
        在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
        给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。



        示例 1：

        输入：s1 = "great", s2 = "rgeat"
        输出：true
        解释：s1 上可能发生的一种情形是：
        "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
        "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
        "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
        "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
        "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
        "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
        算法终止，结果字符串和 s2 相同，都是 "rgeat"
        这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
        示例 2：

        输入：s1 = "abcde", s2 = "caebd"
        输出：false
        示例 3：

        输入：s1 = "a", s2 = "a"
        输出：true*/
/*简单易懂的dp思路，逐行解释
        Jerry
        发布于 2019-12-08
        25.8k
        关于区间dp
        背景：给定一个序列或字符串要进行一些操作，从最后一步出发，要将序列或字符串去头、去尾，如果做过最长回文子串，你就就可以想一下这样子的操作。区间型 dpdp 一般用 dp[i][j]dp[i][j] ，ii 代表左端点，jj 代表右端点，若有其他维度可再添加，若两个端点之间存在联系，则可再压缩空间。力扣上还有一些题也属于区间 dpdp，我推荐大家做一下，下面列出了一些

        5. 最长回文子串
        516. 最长回文子序列
        312. 戳气球
        1246. 删除回文子数组（这个题微软面试问的很多）
        回归正题，开始解答

        初步分析
        给定两个字符串 TT 和 SS，假设 TT 是由 SS 变换而来

        如果 TT 和 SS 长度不一样，必定不能变来
        如果长度一样，顶层字符串 SS 能够划分为 S_1S
        1
        ​
        和 S_2S
        2
        ​
        ，同样字符串 TT 也能够划分为 T_1T
        1
        ​
        和 T_2T
        2
        ​

        情况一：没交换，S_1 ==> T_1S
        1
        ​
        ==>T
        1
        ​
        ，S_2 ==> T_2S
        2
        ​
        ==>T
        2
        ​

        情况二：交换了，S_1 ==> T_2S
        1
        ​
        ==>T
        2
        ​
        ，S_2 ==> T_1S
        2
        ​
        ==>T
        1
        ​

        子问题就是分别讨论两种情况，T_1T
        1
        ​
        是否由 S_1S
        1
        ​
        变来，T_2T
        2
        ​
        是否由 S_2S
        2
        ​
        变来，或 T_1T
        1
        ​
        是否由 S_2S
        2
        ​
        变来，T_2T
        2
        ​
        是否由 S_1S
        1
        ​
        变来。
        image.png
        得到状态
        dp[i][j][k][h]dp[i][j][k][h] 表示 T[k..h]T[k..h] 是否由 S[i..j]S[i..j] 变来。由于变换必须长度是一样的，因此这边有个关系 j - i = h - kj−i=h−k ，可以把四维数组降成三维。dp[i][j][len]dp[i][j][len] 表示从字符串 SS 中 ii 开始长度为 lenlen 的字符串是否能变换为从字符串 TT 中 jj 开始长度为 lenlen 的字符串

        转移方程
        dp[i][j][k]dp[i][j][k]==
        OR_{1<=w<=k-1}OR
        1<=w<=k−1
        ​
        \left\{ dp[i][j][w]\ \ \&\& \ \ dp[i+w][j+w][k-w] \right\}{dp[i][j][w]  &&  dp[i+w][j+w][k−w]} 或
        OR_{1<=w<=k-1}OR
        1<=w<=k−1
        ​
        \left\{ dp[i][j+k-w] [w] \ \ \&\& \ \ dp[i+w][j][k-w] \right\}{dp[i][j+k−w][w]  &&  dp[i+w][j][k−w]}
        解释下：枚举 S_1S
        1
        ​
        长度 ww（从 1～k-11～k−1，因为要划分），f[i] [j] [w]f[i][j][w] 表示 S_1S
        1
        ​
        能变成 T_1T
        1
        ​
        ，f[i+w] [j+w] [k-w]f[i+w][j+w][k−w]表示 S_2S
        2
        ​
        能变成 T_2T
        2
        ​
        ，或者是 S_1S
        1
        ​
        能变成 T_2T
        2
        ​
        ， S_2S
        2
        ​
        能变成 T_1T
        1
        ​
        。

        初始条件
        对于长度是 11 的子串，只有相等才能变过去，相等为 truetrue，不相等为 falsefalse。

        得到答案
        还记得我们的定义吗？dp[i][j][len]dp[i][j][len] 表示从字符串 SS 中 ii 开始长度为 lenlen 的字符串是否能变换为从字符串 TT 中 jj 开始长度为 lenlen 的字符串，所以答案是 dp[0][0][n]dp[0][0][n]。 时间复杂度 O(N^4)O(N
        4
        )，空间复杂度O(N^3)O(N
        3
        )

        如果您觉得我的题解对您有帮助的话，麻烦给个赞鼓励一下吧^o^

        代码

class Solution {
    public boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        // 初始化单个字符的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        // 枚举区间长度 2～n
        for (int len = 2; len <= n; len++) {
            // 枚举 S 中的起点位置
            for (int i = 0; i <= n - len; i++) {
                // 枚举 T 中的起点位置
                for (int j = 0; j <= n - len; j++) {
                    // 枚举划分位置
                    for (int k = 1; k <= len - 1; k++) {
                        // 第一种情况：S1 -> T1, S2 -> T2
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
当然也可以用递归写


class Solution {
    public boolean isScramble(String s1, String s2) {
        // 长度不等，必定不能变换
        if (s1.length() != s2.length()) {
            return false;
        }
        // 长度相等，先特判下
        if (s1.equals(s2)) {
            return true;
        }
        // 看一下字符个数是否一致，不同直接return false
        int n = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        // 相同的话，开始判断判断，满足一个就能 return true
        for (int i = 1; i < n; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                            // S1 -> T2，S2 -> T1
                            (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
下一篇：【负雪明烛】记忆化递归*/
