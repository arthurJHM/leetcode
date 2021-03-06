package com.arthur.leetcode;

/**
 * @title: No530
 * @Author ArthurJi
 * @Date: 2021/4/13 10:23
 * @Version 1.0
 */
public class No530 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        No783.TreeNode left;
        No783.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, No783.TreeNode left, No783.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    No783.TreeNode pre;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(No783.TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(No783.TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(pre != null) {
            min = Math.min(min, Math.abs(pre.val - root.val));
        }
        pre = root;
        dfs(root.right);
    }
}
