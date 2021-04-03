package com.arthur.leetcode;

/**
 * @title: No42
 * @Author ArthurJi
 * @Date: 2021/4/3 16:38
 * @Version 1.0
 */
public class No42 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int len = height.length;
        if(len == 0) {
            return  0;
        }
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int cur = height[i];
            int left = leftMax[i];
            if(left < cur) {
                continue;
            }
            int right = rightMax[i];
            if(right < cur) {
                continue;
            }
            ans += Math.min(right, left) - height[i];
        }

        return ans;
    }
}
/*
42. 接雨水
        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



        示例 1：



        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
        示例 2：

        输入：height = [4,2,0,3,2,5]
        输出：9*/


