package com.arthur.leetcode;

/**
 * @title: No14
 * @Author ArthurJi
 * @Date: 2021/3/22 10:59
 * @Version 1.0
 */
public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            int j = 0;
            while (j < ans.length() && j < strs[i].length()) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }
}

/*14. 最长公共前缀
        编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。



        示例 1：

        输入：strs = ["flower","flow","flight"]
        输出："fl"
        示例 2：

        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。*/

