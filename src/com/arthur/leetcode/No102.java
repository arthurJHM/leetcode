package com.arthur.leetcode;

import java.util.*;

/**
 * @title: No102
 * @Author ArthurJi
 * @Date: 2021/2/19 20:51
 * @Version 1.0
 */
public class No102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null)
            return res;
        deque.add(root);
        while(!deque.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if(treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    deque.add(treeNode.right);
                }
                temp.add(treeNode.val);
            }
            res.add(temp);
        }
        return res;
    }
}
