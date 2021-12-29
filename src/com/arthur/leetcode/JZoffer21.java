package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 调整数组顺序使奇数位于偶数前面
 * @title: JZoffer21
 * @Author hengmingji
 * @Date: 2021/12/29 10:56
 * @Version 1.0
 */
public class JZoffer21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else if (nums[i] % 2 == 1) {
                i++;
            } else if (nums[j] % 2 == 0) {
                j--;
            }
        }
        return nums;
    }
}
