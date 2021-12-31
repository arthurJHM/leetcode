package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 二叉搜索树与双向链表
 * @title: JZoffer36
 * @Author hengmingji
 * @Date: 2021/12/31 21:33
 * @Version 1.0
 */
public class JZoffer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node pre = null;
    Node first = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        first.left = pre;
        pre.right = first;
        return first;
    }

    private void dfs(Node root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(pre != null) {
            pre.right = root;
        } else {
            first = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
