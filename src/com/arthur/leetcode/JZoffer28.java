package com.arthur.leetcode;

import javax.swing.*;

/**
 * @program: leetcode
 * @description: 对称的二叉树
 * @title: JZoffer28
 * @Author hengmingji
 * @Date: 2021/12/23 13:11
 * @Version 1.0
 */
public class JZoffer28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return check(left.left, right.right) && check(right.left, left.right);
        }
        return false;
    }
}
