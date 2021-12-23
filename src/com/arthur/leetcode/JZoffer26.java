package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 树的子结构
 * @title: JZoffer26
 * @Author hengmingji
 * @Date: 2021/12/23 12:44
 * @Version 1.0
 */
public class JZoffer26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A ==null) {
            return false;
        }
        return checkTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean checkTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        } else if (A == null) {
            return false;
        }
        return A.val == B.val && checkTree(A.left, B.left) && checkTree(A.right, B.right);
    }
}
