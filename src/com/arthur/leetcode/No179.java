package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @title: No179
 * @Author ArthurJi
 * @Date: 2021/4/12 9:49
 * @Version 1.0
 */
public class No179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String ans = new String();
        for (String str : strs) {
            ans += str;
        }
        if(ans.charAt(0) == '0') {
            return "0";
        }
        return ans;
    }
}
/*
179. 最大数
        给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

        注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。



        示例 1：

        输入：nums = [10,2]
        输出："210"
        示例 2：

        输入：nums = [3,30,34,5,9]
        输出："9534330"
        示例 3：

        输入：nums = [1]
        输出："1"
        示例 4：

        输入：nums = [10]
        输出："10"*/