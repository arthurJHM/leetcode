package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 环形子数组的最大和
 * @title: No918
 * @Author hengmingji
 * @Date: 2021/12/23 13:26
 * @Version 1.0
 */
public class No918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dpMax[i] = Math.max(dpMax[i - 1] + nums[i], nums[i]);
            max = Math.max(dpMax[i], max);
            dpMin[i] = Math.min(dpMin[i - 1] + nums[i], nums[i]);
            min = Math.min(dpMin[i], min);
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }
}
