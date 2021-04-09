package com.arthur.leetcode;

/**
 * @title: No124
 * @Author ArthurJi
 * @Date: 2021/4/9 12:49
 * @Version 1.0
 */
public class No124 {
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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        max = Math.max(left + right + root.val, max);
        return root.val + Math.max(left, right);
    }
}
/*124. 二叉树中的最大路径和
        路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

        路径和 是路径中各节点值的总和。

        给你一个二叉树的根节点 root ，返回其 最大路径和 。



        示例 1：


        输入：root = [1,2,3]
        输出：6
        解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
        示例 2：


        输入：root = [-10,9,20,null,null,15,7]
        输出：42
        解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42*/
/*
【二叉树中的最大路径和】递归，条理清晰
        Ikaruga
        发布于 2019-08-02
        48.4k
        解题思路：
        二叉树 abc，a 是根结点（递归中的 root），bc 是左右子结点（代表其递归后的最优解）。
        最大的路径，可能的路径情况：


        a
        / \
        b   c
        b + a + c。
        b + a + a 的父结点。
        a + c + a 的父结点。
        其中情况 1，表示如果不联络父结点的情况，或本身是根结点的情况。
        这种情况是没法递归的，但是结果有可能是全局最大路径和。
        情况 2 和 3，递归时计算 a+b 和 a+c，选择一个更优的方案返回，也就是上面说的递归后的最优解啦。

        另外结点有可能是负值，最大和肯定就要想办法舍弃负值（max(0, x)）（max(0,x)）。
        但是上面 3 种情况，无论哪种，a 作为联络点，都不能够舍弃。

        代码中使用 val 来记录全局最大路径和。
        ret 是情况 2 和 3。
        lmr 是情况 1。

        所要做的就是递归，递归时记录好全局最大和，返回联络最大和。

        代码：

        int maxPathSum(TreeNode* root, int &val)
        {
        if (root == nullptr) return 0;
        int left = maxPathSum(root->left, val);
        int right = maxPathSum(root->right, val);
        int lmr = root->val + max(0, left) + max(0, right);
        int ret = root->val + max(0, max(left, right));
        val = max(val, max(lmr, ret));
        return ret;
        }

        int maxPathSum(TreeNode* root)
        {
        int val = INT_MIN;
        maxPathSum(root, val);
        return val;
        }
        下一篇：「手画图解」别纠结递归的细节 | 124.二叉树中的最大路径和
        © 著作权归作者所有
        74
        条评论
        精选评论(3)
        cheney-2
        cheney
        （编辑过）2020-03-28
        思路一致，但是感觉我的注释更好理解~

        int max = Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
        if (root == null) {
        return 0;
        }
        dfs(root);
        return max;
        }

*/
/**
 * 返回经过root的单边分支最大和， 即Math.max(root, root+left, root+right)
 *
 * @param root
 * @return
 *//*

public int dfs(TreeNode root) {
        if (root == null) {
        return 0;
        }
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftMax = Math.max(0, dfs(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightMax = Math.max(0, dfs(root.right));
        //left->root->right 作为路径与已经计算过历史最大值做比较
        max = Math.max(max, root.val + leftMax + rightMax);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(leftMax, rightMax);
        }*/
