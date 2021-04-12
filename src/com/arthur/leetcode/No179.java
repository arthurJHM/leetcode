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
