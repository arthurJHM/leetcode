package com.arthur.bishi.ali.ali0507;

/**
 * @title: No2
 * @Author ArthurJi
 * @Date: 2021/5/7 19:30
 * @Version 1.0
 */

import java.util.*;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 构建二叉树
        TreeNode root = buildTree(nums);
        // 移动二叉树
        moveTree(root, k);

    }



    private static void moveTree(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 队列访问
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();
                list.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            int len = k % list.size();
            // 循环左移
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                tempList.add(list.get((i + len) % list.size()).val);
            }
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                node.val = tempList.get(i);
            }
        }
    }

    private static TreeNode buildTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            createTreeNode(root, nums[i]);
        }
        return root;
    }

    private static void createTreeNode(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                createTreeNode(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                createTreeNode(node.right, val);
            }
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}