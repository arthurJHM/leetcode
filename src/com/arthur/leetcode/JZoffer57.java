package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 和为s的两个数字
 * @title: JZoffer57
 * @Author hengmingji
 * @Date: 2021/12/29 10:52
 * @Version 1.0
 */
public class JZoffer57 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return null;
    }
}
