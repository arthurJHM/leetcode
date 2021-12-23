package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二叉树的镜像
 * @title: JZoffer27
 * @Author hengmingji
 * @Date: 2021/12/23 13:07
 * @Version 1.0
 */
public class JZoffer27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}
