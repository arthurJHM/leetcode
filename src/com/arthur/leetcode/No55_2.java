package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 跳跃游戏
 * @title: No55_2
 * @Author hengmingji
 * @Date: 2021/12/22 21:19
 * @Version 1.0
 */
public class No55_2 {
    public boolean canJump(int[] nums) {
        int max = 0;
        int i = 0;
        while (i <= max) {
            max = Math.max(max, i + nums[i]);
            if(max >= nums.length - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
