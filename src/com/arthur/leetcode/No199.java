package com.arthur.leetcode;

import jdk.internal.org.objectweb.asm.tree.LineNumberNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @title: No199
 * @Author ArthurJi
 * @Date: 2021/3/23 16:12
 * @Version 1.0
 */
public class No199 {
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

    public List<Integer> rightSideView(TreeNode root) {

        LinkedList<TreeNode> temp = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        temp.add(root);
        while (!temp.isEmpty()) {
            int n = temp.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = temp.removeFirst();
                if(treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    temp.add(treeNode.right);
                }
                if(i == n - 1) {
                    ans.add(treeNode.val);
                }
            }
        }
        return ans;
    }
}
/*199. 二叉树的右视图
        给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

        示例:

        输入: [1,2,3,null,5,null,4]
        输出: [1, 3, 4]
        解释:

        1            <---
        /   \
        2     3         <---
        \     \
        5     4       <---
        通过次数93,151提交次数143,333*/
