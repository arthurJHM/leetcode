package com.arthur.leetcodeWeeklyContest.No231Week;

/**
 * @title: No1
 * @Author ArthurJi
 * @Date: 2021/3/7 10:11
 * @Version 1.0
 */
public class No1 {
    public static void main(String[] args) {
        new No1().checkOnesSegment("1001");
    }
    public boolean checkOnesSegment_1(String s) {
        int len = s.length();
        boolean ans = false;
        int flag = 0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '1') {
                ans = true;
                if(flag == 1) {
                    ans = false;
                    return ans;
                }
            }
            if(s.charAt(i) == '0') {
                flag = 1;
            }
        }
        return ans;
    }
    public boolean checkOnesSegment(String s) {
        return s.split("0+").length > 1;
    }
}

/*5697. 检查二进制字符串字段 显示英文描述
        通过的用户数0
        尝试过的用户数0
        用户总通过次数0
        用户总提交次数0
        题目难度Easy
        给你一个二进制字符串 s ，该字符串 不含前导零 。

        如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。



        示例 1：

        输入：s = "1001"
        输出：false
        解释：字符串中的 1 没有形成一个连续字段。
        示例 2：

        输入：s = "110"
        输出：true*/
