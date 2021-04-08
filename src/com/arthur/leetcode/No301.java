package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No301
 * @Author ArthurJi
 * @Date: 2021/4/8 13:24
 * @Version 1.0
 */
public class No301 {
    public static void main(String[] args) {
//        new No301().removeInvalidParentheses("()())()");
        new No301().removeInvalidParentheses(")(f");
    }

    int len = 0;

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        char[] allStr = s.toCharArray();
        int left = 0;
        int right = 0;
        for (char c : allStr) {
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
        }
        int max = Math.min(left, right);
        dfs("", max, 0, 0, set, allStr);

        for (String str : set) {
            if(str.length() >= len) {
                res.add(str);
            }
        }
        return res;
    }

    private void dfs(String curStr, int max, int score, int index, HashSet<String> set, char[] allStr) {
        if (curStr.length() >= len && score == 0) {
            len = Math.max(curStr.length(), len);
            set.add(curStr);
        }
        if(index >= allStr.length) {
            return;
        }
        if(allStr[index] == '(' ) {
            if(score + 1 <= max) {
                dfs(curStr + '(', max, score + 1, index + 1, set, allStr);
            }
            dfs(curStr, max, score, index + 1, set, allStr);
        }else if(allStr[index] == ')') {
            if(score > 0) {
                dfs(curStr + ')', max, score - 1, index + 1, set, allStr);
            }
            dfs(curStr, max, score, index + 1, set, allStr);
        }else if(allStr[index] != '(' && allStr[index] != ')'){
            dfs(curStr + String.valueOf(allStr[index]), max, score, index + 1, set, allStr);
        }
    }
}
/*
301. 删除无效的括号
        给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。

        返回所有可能的结果。答案可以按 任意顺序 返回。



        示例 1:

        输入: "()())()"
        输出: ["()()()", "(())()"]
        示例 2:

        输入: "(a)())()"
        输出: ["(a)()()", "(a())()"]
        示例 3:

        输入: ")("
        输出: [""]


        示例 1：

        输入：s = "()())()"
        输出：["(())()","()()()"]
        示例 2：

        输入：s = "(a)())()"
        输出：["(a())()","(a)()()"]
        示例 3：

        输入：s = ")("
        输出：[""]


        提示：

        1 <= s.length <= 25
        s 由小写英文字母以及括号 '(' 和 ')' 组成
        s 中至多含 20 个括号*/

/*
【一分钟内看懂】将括号的「是否合法」转化为「数学判定」...
        宫水三叶
        发布于 2021-02-25
        1.1k
        DFS 回溯算法
        由于题目要求我们将所有（最长）合法方案输出，因此不可能有别的优化，只能进行「爆搜」。

        我们可以使用 DFS 实现回溯搜索。

        基本思路：

        我们知道所有的合法方案，必然有左括号的数量与右括号数量相等。

        首先我们令左括号的得分为 1；右括号的得分为 -1。那么对于合法的方案而言，必定满足最终得分为 0。

        同时我们可以预处理出「爆搜」过程的最大得分： max = min(左括号的数量, 右括号的数量)

        PS.「爆搜」过程的最大得分必然是：合法左括号先全部出现在左边，之后使用最多的合法右括号进行匹配。

        枚举过程中出现字符分三种情况：

        普通字符：无须删除，直接添加
        左括号：如果当前得分不超过 max - 1 时，我们可以选择添加该左括号，也能选择不添加
        右括号：如果当前得大于 0（说明有一个左括号可以与之匹配），我们可以选择添加该右括号，也能选择不添加
        使用 Set 进行方案去重，len 记录「爆搜」过程中的最大子串，然后将所有结果集中长度为 len 的子串加入答案：


class Solution {
    int len;
    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        for (char c : cs) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }
        int max = Math.min(l, r);
        Set<String> all = new HashSet<>();
        dfs(cs, 0, 0, max, "", all);
        List<String> ans = new ArrayList<>();
        for (String str : all) {
            if (str.length() == len) ans.add(str);
        }
        return ans;
    }
    */
/**
 * cs: 字符串 s 对应的字符数组
 * u: 当前决策到 cs 的哪一位
 * score: 当前决策方案的得分值（每往 cur 追加一个左括号进行 +1；每往 cur 追加一个右括号进行 -1）
 * max: 整个 dfs 过程的最大得分
 * cur: 当前决策方案
 * ans: 合法方案结果集
 *//*

    void dfs(char[] cs, int u, int score, int max, String cur, Set<String> ans) {
        if (u == cs.length) {
            if (score == 0 && cur.length() >= len) {
                len = Math.max(len, cur.length());
                ans.add(cur);
            }
            return;
        }
        if (cs[u] == '(') {
            if (score + 1 <= max) dfs(cs, u + 1, score + 1, max, cur + "(", ans);
            dfs(cs, u + 1, score, max, cur, ans);
        } else if (cs[u] == ')') {
            if (score > 0) dfs(cs, u + 1, score - 1, max, cur + ")", ans);
            dfs(cs, u + 1, score, max, cur, ans);
        } else {
            dfs(cs, u + 1, score, max, cur + String.valueOf(cs[u]), ans);
        }
    }
}
时间复杂度：不考虑 score 带来的剪枝效果，最坏情况下，每个位置都有两种选择。复杂度为 O(n * 2^n)O(n∗2
        n
        )
        空间复杂度：最大合法方案数与字符串长度最多呈线性关系。复杂度为 O(n)O(n)
        最后
        如果有帮助到你，请给个点赞关注，让更多的人看到 ~ ("▔□▔)/

        也欢迎你 关注我 ，和三叶一起刷穿 LeetCode ~*/
