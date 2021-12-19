package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 数组中重复的数字
 * @title: jzoffer3
 * @Author hengmingji
 * @Date: 2021/12/17 22:02
 * @Version 1.0
 */
public class JZoffer3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == i) {
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return 0;
    }
}
