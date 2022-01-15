package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 重建二叉树
 * @title: JZoffer7
 * @Author hengmingji
 * @Date: 2022/1/13 23:29
 * @Version 1.0
 */
public class JZoffer7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preorder;
    HashMap<Integer, Integer> map;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return recur(0, 0, preorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        treeNode.left = recur(root + 1,left,i - 1);
        treeNode.right = recur(root + (i - left) + 1, i + 1, right);
        return treeNode;
    }

}
