package com.arthur.leetcode;

/**
 * @title: No783
 * @Author ArthurJi
 * @Date: 2021/4/13 10:03
 * @Version 1.0
 */
public class No783 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode pre;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
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
