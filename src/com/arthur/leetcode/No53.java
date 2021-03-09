package com.arthur.leetcode;

/**
 * @title: No53
 * @Author ArthurJi
 * @Date: 2021/3/9 11:10
 * @Version 1.0
 */
public class No53 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
/*
53. 最大子序和
        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。



        示例 1：

        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        输出：6
        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        示例 2：

        输入：nums = [1]
        输出：1
        示例 3：

        输入：nums = [0]
        输出：0
        示例 4：

        输入：nums = [-1]
        输出：-1*/
