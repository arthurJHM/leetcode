package com.arthur.leetcode;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: I. 从上到下打印二叉树
 * @title: JZoffer32
 * @Author hengmingji
 * @Date: 2021/12/22 20:06
 * @Version 1.0
 */
public class JZoffer32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return new int[0];
        }
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.removeFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
