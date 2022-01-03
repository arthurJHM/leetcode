package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: II. 平衡二叉树
 * @title: JZoffer55_2
 * @Author hengmingji
 * @Date: 2022/1/3 15:08
 * @Version 1.0
 */
public class JZoffer55_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) < 2) {
            return Math.max(left, right) + 1    ;
        } else {
            return -1;
        }
    }
}
