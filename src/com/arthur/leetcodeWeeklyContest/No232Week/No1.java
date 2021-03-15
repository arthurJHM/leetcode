package com.arthur.leetcodeWeeklyContest.No232Week;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/3/14 10:31
 * @Version 1.0
 */
public class No1 {

    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        char[] temp1 = new char[10];
        char[] temp2 = new char[10];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                temp1[j] = s1.charAt(i);
                temp2[j++] = s2.charAt(i);
            }
            if(j == 3) {
                return false;
            }
        }
        if(j == 0) {
            return true;
        }
        if(j == 2 && temp1[0] == temp2[1] && temp1[1] == temp2[0]) {
            return true;
        }
        if(j == 1 && temp1[0] == temp2[0]) {
            return true;
        }
        return false;
    }
}

/*
5701. 仅执行一次字符串交换能否使两个字符串相等 显示英文描述
        通过的用户数0
        尝试过的用户数0
        用户总通过次数0
        用户总提交次数0
        题目难度Easy
        给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。

        如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。



        示例 1：

        输入：s1 = "bank", s2 = "kanb"
        输出：true
        解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
        示例 2：

        输入：s1 = "attack", s2 = "defend"
        输出：false
        解释：一次字符串交换无法使两个字符串相等
        示例 3：

        输入：s1 = "kelb", s2 = "kelb"
        输出：true
        解释：两个字符串已经相等，所以不需要进行字符串交换
        示例 4：

        输入：s1 = "abcd", s2 = "dcba"
        输出：false
*/
