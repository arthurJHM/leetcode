package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: I. 二叉树的深度
 * @title: JZoffer55
 * @Author hengmingji
 * @Date: 2022/1/3 15:05
 * @Version 1.0
 */
public class JZoffer55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int deep = 0;
    int ans = 0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        deep++;
        ans = Math.max(ans, deep);
        dfs(root.left);
        dfs(root.right);
        deep--;
    }
}
