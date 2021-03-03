package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No139
 * @Author ArthurJi
 * @Date: 2021/3/3 19:31
 * @Version 1.0
 */
public class No139 {
    public static void main(String[] args) {
//        boolean res = new No139().wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code")));
        boolean res = new No139().wordBreak("aaaaaaa", new ArrayList<String>(Arrays.asList("aaaa", "aaa")));
        System.out.println(res);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] ans = new boolean[len + 1];
        ans[0] = true;
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if(ans[i] && set.contains(s.substring(i,j))) {
                    ans[j] = true;
                }
            }
        }
        return ans[len];
    }
    public boolean wordBreak_2(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] ans = new boolean[len + 1];
        ans[0] = true;
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= i; j++) {
                if(ans[j] && set.contains(s.substring(j, i))) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[len];
    }

    public boolean wordBreak_3(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] ans = new boolean[len + 1];
        ans[0] = true;
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        for (int i = 0; i <= len; i++) {
            for (int j = i; j >= 0; j--) {
                if(ans[j] && set.contains(s.substring(j, i))) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[len];
    }
}


//其中方法2更容易理解
//方法3跟2思路稍微不一样，但是会更快一些
/*
139. 单词拆分
        给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

        说明：

        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。
        示例 1：

        输入: s = "leetcode", wordDict = ["leet", "code"]
        输出: true
        解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
        示例 2：

        输入: s = "applepenapple", wordDict = ["apple", "pen"]
        输出: true
        解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
        注意你可以重复使用字典中的单词。
        示例 3：

        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        输出: false*/
/*
解题思路
        动态规划听上去非常高大上，但是其实都是源自于一个很自然的想法，就拿这道题来说，假如需要判断"onetwothreefour"这一个字符串能不能满足条件，我们很自然的想法就是：
        如果"onetwothree"这一段可以拆分，再加上four如果也可以，那不就行了；
        或者
        如果"onetwothre"这一段可以拆分，再加上efour如果也可以，那不就行了；
        这其实已经抓住了动态规划的最核心的东西了，换成式子来表达，就是


        dp["onetwothreefour"] = dp["onetwothree"这一段] && 判断一下"four"
        dp["onetwothreefour"] = dp["onetwothre"这一段] && 判断一下"efour"
        这道题就搞定啦~

        动态规划的基本操作：
        定义dp数组
        初始化
        转化公式
        搞定！
        小窍门
        这道题的遍历顺序稍微有点窍门，就是：要判断dp[j]，最好按照 dp[j-1]&&check() -> dp[j-2]&&check -> dp[0]&&check()这个顺序,理由很简单，这样的话check的部分就相当于判断单词是否存在，仔细想想呗~

        代码

class Solution {
    */
/*
        动态规划算法，dp[i]表示s前i个字符能否拆分
        转移方程：dp[j] = dp[i] && check(s[i+1, j]);
        check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
        其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
        这个举个例子就很容易理解。
        假如wordDict=["apple", "pen", "code"],s = "applepencode";
        dp[8] = dp[5] + check("pen")
        翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
        （注意：i的顺序是从j-1 -> 0哦~
    *//*


    public HashMap<String, Boolean> hash = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        //方便check，构建一个哈希表
        for(String word : wordDict){
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for(int j = 1; j <= s.length(); j++){
            for(int i = j-1; i >= 0; i--){
                dp[j] = dp[i] && check(s.substring(i, j));
                if(dp[j])   break;
            }
        }

        return dp[s.length()];
    }

    public boolean check(String s){
        return hash.getOrDefault(s, false);
    }
}

作者：RED_DEVIL
        链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-ju-jue-zhuang-xcong-jian-dan-de-xi/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
