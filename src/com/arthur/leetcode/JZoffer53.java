package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: I. 在排序数组中查找数字 I
 * @title: JZoffer53
 * @Author hengmingji
 * @Date: 2021/12/20 15:53
 * @Version 1.0
 */
public class JZoffer53 {
    public int search(int[] nums, int target) {
        int left;
        int right;
        int mid;
        int l = 0;
        int r = nums.length - 1;
        //左边界
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        if (l >= nums.length || nums[l] != target) {
//            left = nums.length - 1;
            return 0;
        } else {
            left = l;
        }
        //右边界
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        if (r < 0 || nums[r] != target) {
            right = 0;
        } else {
            right = r;
        }
        System.out.println(right);
        System.out.println(left);
        return right - left + 1;
    }
}
