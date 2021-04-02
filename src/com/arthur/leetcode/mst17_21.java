package com.arthur.leetcode;

/**
 * @title: mst17_21
 * @Author ArthurJi
 * @Date: 2021/4/2 11:11
 * @Version 1.0
 */
public class mst17_21 {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int len = height.length;
        if(len == 0) {
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int cur = height[i];
            int lm = left[i];
            if(lm < cur) {
                continue;
            }
            int rm = right[i];
            if(rm < cur) {
                continue;
            }
            ans += Math.min(lm, rm) - cur;
        }
        return ans;
    }

}
/*
面试题 17.21. 直方图的水量
        给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。



        上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。

        示例:

        输入: [0,1,0,2,1,0,1,3,2,1,2,1]
        输出: 6
*/
