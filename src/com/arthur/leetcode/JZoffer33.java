package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二叉搜索树的后序遍历序列
 * @title: JZoffer33
 * @Author hengmingji
 * @Date: 2022/1/14 21:05
 * @Version 1.0
 */
public class JZoffer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int n = i;
        while (postorder[n] < postorder[j]) {
            n++;
        }
        int mid = n;
        while (postorder[n] > postorder[j]) {
            n++;
        }
        return n == j && recur(postorder, i, mid - 1) && recur(postorder, mid , j - 1);
    }
}
