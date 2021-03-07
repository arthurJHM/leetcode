package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No131
 * @Author ArthurJi
 * @Date: 2021/3/7 10:16
 * @Version 1.0
 */
public class No131 {
    public static void main(String[] args) {
        new No131().partition("aab");
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> ans = new ArrayList<>();
        Stack<String> path = new Stack<String>();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len * 2 - 1; i++) {
            huiwenpro(s, dp, i / 2, (i + 1) / 2);
        }
        dfs(s, 0, dp, ans, path);
        return ans;
    }

    private void dfs(String s, int k, boolean[][] dp, List<List<String>> ans, Stack<String> path) {
        if (k == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = k; i < s.length(); i++) {
            if (dp[k][i]) {
//                path.push(new String(s.substring(k, i + 1)));
                path.push(s.substring(k, i + 1));
                dfs(s, i + 1, dp, ans, path);
                path.pop();
            }
        }
    }

    private void huiwenpro(String s, boolean[][] dp, int i, int j) {
//        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1] == true)) { //不用判断那么多
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = true;
            i--;
            j++;
        }
    }
}

/*
131. 分割回文串
        给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

        返回 s 所有可能的分割方案。

        示例:

        输入: "aab"
        输出:
        [
        ["aa","b"],
        ["a","a","b"]
        ]*/
/*
思路分析：找到所有可能的解，提示我们可以使用「回溯算法」（采用深度优先遍历的方式遍历一棵隐式树结构）。

        对回溯算法还不太熟悉的朋友，可以参考：回溯算法入门级详解 + 练习（持续更新）。

        方法一：回溯算法
        回溯算法思考的步骤：

        画出树型结构，本题的递归树模型是一棵二叉树；
        友情提示：强烈建议大家根据一个具体例子画出树形图。



        编码。
        每一个结点表示剩余没有扫描到的字符串，产生分支是截取了剩余字符串的前缀；
        产生前缀字符串的时候，判断前缀字符串是否是回文。
        如果前缀字符串是回文，则可以产生分支和结点；
        如果前缀字符串不是回文，则不产生分支和结点，这一步是剪枝操作。
        在叶子结点是空字符串的时候结算，此时 从根结点到叶子结点的路径，就是结果集里的一个结果，使用深度优先遍历，记录下所有可能的结果。
        使用一个路径变量 path 搜索，path 全局使用一个（注意结算的时候，要生成一个拷贝），因此在递归执行方法结束以后需要回溯，即将递归之前添加进来的元素拿出去；
        path 的操作只在列表的末端，因此合适的数据结构是栈。
        参考代码 1：

        Java

        import java.util.ArrayDeque;
        import java.util.ArrayList;
        import java.util.Deque;
        import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    */
/**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     *//*

    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }
    }

    */
/**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     *//*

    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
复杂度分析：

        时间复杂度：O(N \cdot 2^N)O(N⋅2
        N
        )；这里 NN 为输入字符串的长度，每一个位置可拆分，也可不拆分，尝试是否可以拆分的时间复杂度为 O(2^N)O(2
        N
        )，判断每一个子串是否是回文子串，时间复杂度为 O(N)O(N)；
        空间复杂度：O(N)O(N)，递归调用栈的高度为 NN。
        验证回文串的时候，每一次都得使用「双指针」的方式验证子串是否是回文子串。利用「力扣」第 5 题：最长回文子串 的思路，可以先用动态规划把结果算出来，这样就可以以 O(1)O(1) 的时间复杂度直接得到一个子串是否是回文。

        方法二：回溯的优化（使用动态规划得到所有子串是否是回文）
        参考代码 2：

        Java

        import java.util.ArrayDeque;
        import java.util.ArrayList;
        import java.util.Deque;
        import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        char[] charArray = s.toCharArray();
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, dp, stack, res);
        return res;
    }

    private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }
}
复杂度分析：

        时间复杂度：O(2^N)O(2
        N
        )；这里 NN 为输入字符串的长度，每一个位置可拆分，也可不拆分，尝试是否可以拆分的时间复杂度为 O(2^N)O(2
        N
        )，动态规划得到所有子串是否为回文子串的时间复杂度为 O(N^2)O(N
        2
        )，所以总的时间复杂度为 O(N^2 + 2^N) = O(2^N)O(N
        2
        +2
        N
        )=O(2
        N
        )；
        空间复杂度：O(N^2)O(N
        2
        )，动态规划表格的大小为 N^2N
        2
        ，递归调用栈的高度为 NN，空间复杂度为 O(N^2 + N) = O(N)O(N
        2
        +N)=O(N)。
        补充：

        事实上，还可以使用中心扩散的方法得到所有子串是否是回文，可以参考 评论。

        作者：liweiwei1419
        链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
