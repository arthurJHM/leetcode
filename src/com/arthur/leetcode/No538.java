package com.arthur.leetcode;

/**
 * @title: No538
 * @Author ArthurJi
 * @Date: 2021/2/19 14:09
 * @Version 1.0
 */
public class No538 {

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
    int sum = 0;
    public static void main(String[] args) {
    }
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        convertBST(root.right);

        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }
}

//538. 把二叉搜索树转换为累加树 反中序遍历