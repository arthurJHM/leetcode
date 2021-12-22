package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 从上到下打印二叉树 III
 * @title: JZoffer32_3
 * @Author hengmingji
 * @Date: 2021/12/22 20:52
 * @Version 1.0
 */
public class JZoffer32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        queue.add(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            if(flag == 0) {
                for (int i = 0; i < len; i++) {
                    TreeNode treeNode = queue.removeFirst();
                    temp.add(treeNode.val);
                    if(treeNode.left != null) {
                        queue.addLast(treeNode.left);
                    }
                    if(treeNode.right != null) {
                        queue.addLast(treeNode.right);
                    }
                }
                flag = 1;
            } else {
                for (int i = 0; i < len; i++) {
                    TreeNode treeNode = queue.removeLast();
                    temp.add(treeNode.val);
                    if(treeNode.right != null) {
                        queue.addFirst(treeNode.right);
                    }
                    if(treeNode.left != null) {
                        queue.addFirst(treeNode.left);
                    }
                }
                flag = 0;
            }
            ans.add(temp);
        }
        return ans;
    }
}
