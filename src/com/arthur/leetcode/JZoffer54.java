package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二叉搜索树的第k大节点
 * @title: JZoffer54
 * @Author hengmingji
 * @Date: 2021/12/31 21:56
 * @Version 1.0
 */
public class JZoffer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int n = 0;
    int i = 0;
    int ans = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
//        System.out.println(n);
        dfs(root, n - k + 1);
        return ans;
    }

    private void dfs(TreeNode root, int n) {
        if (root == null) {
            return;
        }
        dfs(root.left, n);

        if (++i == n) {
            ans = root.val;
            return;
        }
        dfs(root.right, n);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        n++;
        dfs(root.left);
        dfs(root.right);
    }
}
