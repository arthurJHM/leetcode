package com.arthur.leetcode;

/**
 * @title: No109
 * @Author ArthurJi
 * @Date: 2021/3/19 10:20
 * @Version 1.0
 */
public class No109 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public static void main(String[] args) {

    }
}
/*109. 有序链表转换二叉搜索树
        给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

        示例:

        给定的有序链表： [-10, -3, 0, 5, 9],

        一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

        0
        / \
        -3   9
        /   /
        -10  5*/
