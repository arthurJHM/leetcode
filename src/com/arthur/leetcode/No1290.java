package com.arthur.leetcode;

/**
 * @title: No1290
 * @Author ArthurJi
 * @Date: 2021/3/19 10:14
 * @Version 1.0
 */
public class No1290 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            if (head.val == 1) {
                ans = ans * 2 + 1;
            } else {
                ans *= 2;
            }
            head = head.next;

        }
        return ans;
    }
}

/*
1290. 二进制链表转整数
        给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

        请你返回该链表所表示数字的 十进制值 。



        示例 1：



        输入：head = [1,0,1]
        输出：5
        解释：二进制数 (101) 转化为十进制数 (5)
        示例 2：

        输入：head = [0]
        输出：0
        示例 3：

        输入：head = [1]
        输出：1
        示例 4：

        输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
        输出：18880
        示例 5：

        输入：head = [0,0]
        输出：0
*/
