package com.arthur.bishi.ali0812;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/12 20:20
 * @modifiedBy：
 * @version: 1.0
 */
class Solution {
    public static void main(String[] args) {
//        nextPermutation();
    }
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
        return;

    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
