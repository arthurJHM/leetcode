package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 乘积最大子数组 二刷
 * @title: No152_2
 * @Author hengmingji
 * @Date: 2021/12/24 14:08
 * @Version 1.0
 */
public class No152_2 {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                dpMax[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i - 1] * nums[i]);
            } else {
                dpMax[i] = Math.max(nums[i], dpMax[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int max : dpMax) {
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
