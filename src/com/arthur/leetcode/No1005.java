package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: K 次取反后最大化的数组和
 * @title: No1005
 * @Author hengmingji
 * @Date: 2021/12/25 16:16
 * @Version 1.0
 */
public class No1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (k > 0 && i < nums.length) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                i++;
                k--;
            } else {
                break;
            }
        }
        if (k > 0) {
            if (k % 2 == 1) {
                Arrays.sort(nums);
                nums[0] = -nums[0];
            }
        }
        return Arrays.stream(nums).sum();
    }
}
