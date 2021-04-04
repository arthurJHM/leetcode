package com.arthur.leetcode;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @title: No84
 * @Author ArthurJi
 * @Date: 2021/4/3 20:36
 * @Version 1.0
 */
public class No84 {
    public static void main(String[] args) {
        new No84().largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (newHeights[stack.peekLast()] > newHeights[i]) {
                Integer pop = stack.pollLast();
                int temp = newHeights[pop] * (i - stack.peekLast() - 1);
                ans = Math.max(ans, temp);
            }
            stack.addLast(i);
        }
        return ans;
    }
}
/*84. 柱状图中最大的矩形
        给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

        求在该柱状图中，能够勾勒出来的矩形的最大面积。





        以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。





        图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。



        示例:

        输入: [2,1,5,6,2,3]
        输出: 10
        通过次数137,138提交次数319,970
        在真实的面试中遇到过这道题？*/
