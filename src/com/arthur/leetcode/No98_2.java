package com.arthur.leetcode;

/**
 * @title: No98_2
 * @Author ArthurJi
 * @Date: 2021/3/8 11:34
 * @Version 1.0
 */
public class No98_2 {
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

    public static void main(String[] args) {

    }

    long pre = Long.MIN_VALUE;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        mid(root);
        return flag;
    }

    private void mid(TreeNode root) {
        if (!flag) {
            return;
        }
        if (root == null) {
            return;
        }

        mid(root.left);
        if (pre >= root.val) {
            flag = false;
            return;
        }
        pre = root.val;
        mid(root.right);
    }
}
