package com.arthur.leetcode;

/**
 * @title: No11
 * @Author ArthurJi
 * @Date: 2021/2/20 14:45
 * @Version 1.0
 */
public class No11 {
    public static void main(String[] args) {
        System.out.println(new No11().maxArea1(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) { // 暴力
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * Math.abs(i - j));
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right) {
            res = Math.max(res, Math.min(height[left],height[right]) * (right - left));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

//面积取决于短板。①因此即使长板往内移动时遇到更长的板，矩形的面积也不会改变；遇到更短的板时，面积会变小。
// ②因此想要面积变大，只能让短板往内移动(因为移动方向固定了)，当然也有可能让面积变得更小，但只有这样才存在让面积变大的可能性
