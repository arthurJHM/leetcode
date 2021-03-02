package com.arthur.leetcode;

/**
 * @title: No303
 * @Author ArthurJi
 * @Date: 2021/3/1 23:49
 * @Version 1.0
 */
public class No303 {
    public static void main(String[] args) {

    }
    int preSum[];


    public No303(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j+1] - preSum[i];
    }
}
