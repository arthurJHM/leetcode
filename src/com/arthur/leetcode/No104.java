package com.arthur.leetcode;

import static jdk.nashorn.internal.objects.NativeMath.max;

/**
 * @title: No104
 * @Author ArthurJi
 * @Date: 2021/3/19 10:40
 * @Version 1.0
 */
public class No104 {

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

    int max = 0;
    public int maxDepth(TreeNode root) {
        maxdep(root, 1);
        return max;
    }

    private void maxdep(TreeNode root, int deep) {
        if(root == null ){
            return;
        }
        max = Math.max(max, deep);
        maxdep(root.left, deep + 1);
        maxdep(root.right, deep + 1);
    }
}

/*104. 二叉树的最大深度
        给定一个二叉树，找出其最大深度。

        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

        说明: 叶子节点是指没有子节点的节点。

        示例：
        给定二叉树 [3,9,20,null,null,15,7]，

        3
        / \
        9  20
        /  \
        15   7
        返回它的最大深度 3 。*/
