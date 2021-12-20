package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: II. 0～n-1中缺失的数字
 * @title: JZoffer53II
 * @Author hengmingji
 * @Date: 2021/12/20 16:39
 * @Version 1.0
 */
public class JZoffer53II {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left < 0 ? 0 : left;
    }
}
