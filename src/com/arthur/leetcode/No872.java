package com.arthur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: No872
 * @Author ArthurJi
 * @Date: 2021/5/10 14:29
 * @Version 1.0
 */
public class No872 {
    public static void main(String[] args) {

    }

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

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs1(root1, list1);
        dfs1(root2, list2);
        if(list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }


    private void dfs1(TreeNode root1, List<Integer> list1) {
        if(root1 == null) {
            return;
        }
        if(root1.left == null && root1.right == null) {
            list1.add(root1.val);
            return;
        }
        dfs1(root1.left, list1);
        dfs1(root1.right, list1);
    }
}
/*872. 叶子相似的树
        请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



        举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

        如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

        如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。



        示例 1：



        输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        输出：true
        示例 2：

        输入：root1 = [1], root2 = [1]
        输出：true
        示例 3：

        输入：root1 = [1], root2 = [2]
        输出：false
        示例 4：

        输入：root1 = [1,2], root2 = [2,2]
        输出：true
        示例 5：



        输入：root1 = [1,2,3], root2 = [1,3,2]
        输出：false
 */
