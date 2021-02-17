package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @title: No566
 * @Author ArthurJi
 * @Date: 2021/2/17 12:59
 * @Version 1.0
 */
public class No566 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        int[][] ans = new No566().matrixReshape(nums, 1 ,4);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ans = new int[r][c];
        if(r * c != nums.length * nums[0].length) {
            return nums;
        }
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp.offer(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = temp.poll();
            }
        }
        return ans;
    }
}
