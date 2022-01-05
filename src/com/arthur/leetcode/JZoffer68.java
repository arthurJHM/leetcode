package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: I. 二叉搜索树的最近公共祖先
 * @title: JZoffer68
 * @Author hengmingji
 * @Date: 2022/1/4 16:00
 * @Version 1.0
 */
public class JZoffer68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
    }
}
