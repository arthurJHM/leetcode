package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 至少是其他数字两倍的最大数
 * @title: No747
 * @Author hengmingji
 * @Date: 2022/1/13 22:35
 * @Version 1.0
 */
public class No747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i = 0, j = -1;
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] > nums[i]) {
                j = i;
                i = k;
            } else if (j == -1 || nums[k] > nums[j]) {
                j = k;
            }
        }
        if (nums[i] >= nums[j] * 2) {
            return i;
        } else {
            return -1;
        }
    }
}
