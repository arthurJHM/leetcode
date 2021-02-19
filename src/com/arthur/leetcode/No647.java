package com.arthur.leetcode;

import sun.font.TrueTypeFont;

/**
 * @title: No647
 * @Author ArthurJi
 * @Date: 2021/2/19 15:02
 * @Version 1.0
 */
public class No647 {

    public static void main(String[] args) {
        System.out.println(new No647().countSubstrings1(new String("aaa")));
    }

    public int countSubstrings(String s) {  //动态规划解法
        int len = s.length();
        int result = 0;
        boolean[][] ans= new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if(s.charAt(j) == s.charAt(i) && (i - j < 2 || ans[j + 1][i - 1] == true)) {
                    ans[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }
    public int countSubstrings1(String s) {  //动态规划解法
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len * 2 - 1; i++) {  //i的范围很重要
            int left = i / 2;
            int right = left + i % 2;   //right和left的取值怎么取也很重要
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}

/*647. 回文子串
        给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



        示例 1：

        输入："abc"
        输出：3
        解释：三个回文子串: "a", "b", "c"
        示例 2：

        输入："aaa"
        输出：6
        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"*/

/*本题是找到一个字符串中所有的回文子串，而第 5 题是求解一个字符串中最长的回文子串，很明显求解出所有的字符串自然能够找到最大的，所以我们先看 647 题。

        1. 动态规划法
        首先这一题可以使用动态规划来进行解决：

        状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
        状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false
        这个状态转移方程是什么意思呢？

        当只有一个字符时，比如 a 自然是一个回文串。
        当有两个字符时，如果是相等的，比如 aa，也是一个回文串。
        当有三个及以上字符时，比如 ababa 这个字符记作串 1，把两边的 a 去掉，也就是 bab 记作串 2，可以看出只要串2是一个回文串，那么左右各多了一个 a 的串 1 必定也是回文串。所以当 s[i]==s[j] 时，自然要看 dp[i+1][j-1] 是不是一个回文串。
        所以最后代码为：

        Java

class Solution {
    public int countSubstrings(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
上述代码，时间复杂度为 O(N^2)O(N
        2
        )，空间复杂度为 O(N^2)O(N
        2
        )。

        2. 中心扩展法
        这是一个比较巧妙的方法，实质的思路和动态规划的思路类似。

        比如对一个字符串 ababa，选择最中间的 a 作为中心点，往两边扩散，第一次扩散发现 left 指向的是 b，right 指向的也是 b，所以是回文串，继续扩散，同理 ababa 也是回文串。

        这个是确定了一个中心点后的寻找的路径，然后我们只要寻找到所有的中心点，问题就解决了。

        中心点一共有多少个呢？看起来像是和字符串长度相等，但你会发现，如果是这样，上面的例子永远也搜不到 abab，想象一下单个字符的哪个中心点扩展可以得到这个子串？似乎不可能。所以中心点不能只有单个字符构成，还要包括两个字符，比如上面这个子串 abab，就可以有中心点 ba 扩展一次得到，所以最终的中心点由 2 * len - 1 个，分别是 len 个单字符和 len - 1 个双字符。

        如果上面看不太懂的话，还可以看看下面几个问题：

        为什么有 2 * len - 1 个中心点？
        aba 有5个中心点，分别是 a、b、c、ab、ba
        abba 有7个中心点，分别是 a、b、b、a、ab、bb、ba
        什么是中心点？
        中心点即 left 指针和 right 指针初始化指向的地方，可能是一个也可能是两个
        为什么不可能是三个或者更多？
        因为 3 个可以由 1 个扩展一次得到，4 个可以由两个扩展一次得到
        Java

class Solution6472 {
    public int countSubstrings(String s) {
        // 中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
    这个方法的时间复杂度是 O(N^2)O(N
        2
        )，空间复杂度是 O(1)O(1)。

        这个解法也同样适用于 leetcode 5 最长回文子串，按上述代码，稍作修改，即可得到，第五题的解法:

        Java

class Solution {
    public String longestPalindrome(String s) {
        // ababa 求最长公共子串
        int len = s.length();
        String result = "";

        for (int i = 0; i < len * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String tmp = s.substring(left, right + 1);
                if (tmp.length() > result.length()) {
                    result = tmp;
                }
                left--;
                right++;
            }
        }
        return result;
    }
}

作者：jawhiow
        链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
