package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 接雨水_二刷
 * @title: No42_2
 * @Author hengmingji
 * @Date: 2021/12/27 14:44
 * @Version 1.0
 */
public class No42_2 {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        maxLeft[0] = Integer.MIN_VALUE;
        int[] maxRight = new int[len];
        maxRight[len - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }

        return ans;
    }
}
