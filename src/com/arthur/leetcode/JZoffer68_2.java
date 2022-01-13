package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: II. 二叉树的最近公共祖先
 * @title: JZoffer68_2
 * @Author hengmingji
 * @Date: 2022/1/13 23:03
 * @Version 1.0
 */
public class JZoffer68_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null ) {
            return null;
        }
        if(left == null && right != null) {
            return right;
        }
        if(left != null && right == null) {
            return left;
        }
        return root;
    }
}
