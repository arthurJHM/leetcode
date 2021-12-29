package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 统计特殊四元组
 * @title: No1995
 * @Author hengmingji
 * @Date: 2021/12/29 10:20
 * @Version 1.0
 */
public class No1995 {
    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if(nums[i] +nums[j] + nums[k] == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
