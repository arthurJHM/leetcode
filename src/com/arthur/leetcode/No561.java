package com.arthur.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @title: No561
 * @Author ArthurJi
 * @Date: 2021/2/16 14:31
 * @Version 1.0
 */
public class No561 {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i+=2) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }
}
