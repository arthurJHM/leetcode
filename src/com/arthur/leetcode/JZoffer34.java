package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 二叉树中和为某一值的路径
 * @title: JZoffer34
 * @Author hengmingji
 * @Date: 2021/12/31 21:06
 * @Version 1.0
 */
public class JZoffer34 {
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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        return dfs(root, target, lists, list);
    }

    private List<List<Integer>> dfs(TreeNode root, int target, List<List<Integer>> lists, LinkedList<Integer> list) {
        if (root == null) {
            return lists;
        }
        if (target == root.val && root.left == null && root.right == null) {
            list.addLast(root.val);
            lists.add(new ArrayList<>(list));
            list.removeLast();
            return lists;
        }
        list.addLast(root.val);
        dfs(root.left, target - root.val, lists, list);
        dfs(root.right, target - root.val, lists, list);
        list.removeLast();
        return lists;
    }
}
