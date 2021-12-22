package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: II. 从上到下打印二叉树 II
 * @title: JZoffer32_2
 * @Author hengmingji
 * @Date: 2021/12/22 20:37
 * @Version 1.0
 */
public class JZoffer32_2 {
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
        queue.addLast(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.removeFirst();
                list.add(treeNode.val);
                if(treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if(treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
