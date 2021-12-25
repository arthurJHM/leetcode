package com.arthur.leetcode;

import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 奇偶树
 * @title: No1609
 * @Author hengmingji
 * @Date: 2021/12/25 14:35
 * @Version 1.0
 */
public class No1609 {
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

    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = null;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                if(treeNode.val % 2 == level % 2) {
                    return false;
                }
                if (treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
                if (i == 0) {
                    temp = treeNode;
                } else {
                    if (level % 2 == 0) {
                        if (treeNode.val <= temp.val) {
                            return false;
                        }
                        temp = treeNode;
                    } else if (level % 2 == 1) {
                        if (treeNode.val >= temp.val) {
                            return false;
                        }
                        temp = treeNode;
                    }
                }
            }
            level++;
        }
        return true;
    }
}
