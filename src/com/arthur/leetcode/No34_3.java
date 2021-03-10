package com.arthur.leetcode;

/**
 * @title: No34_3
 * @Author ArthurJi
 * @Date: 2021/3/10 12:56
 * @Version 1.0
 */
public class No34_3 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int left = findFirstPosition(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = findFirstPosition_2(nums, target + 1) - 1;  //互补的求下界的函数，再减一得到上界
        return new int[]{left, right};
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        if(left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findFirstPosition_2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
}
