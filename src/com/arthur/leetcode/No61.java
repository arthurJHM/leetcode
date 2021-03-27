package com.arthur.leetcode;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.List;

/**
 * @title: No61
 * @Author ArthurJi
 * @Date: 2021/3/27 9:36
 * @Version 1.0
 */
public class No61 {
    public static void main(String[] args) {


    }


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

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        ListNode temp = head;
        while (temp!= null){
            len++;
            temp = temp.next;
        }
        int n = k % len;
        if(n == 0) {
            return head;
        }
        while (fast != null && n-- != 0) {
            fast = fast.next;
        }
        while (fast.next != null ) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;

    }
}

/*
61. 旋转链表
        给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



        示例 1：


        输入：head = [1,2,3,4,5], k = 2
        输出：[4,5,1,2,3]
        示例 2：


        输入：head = [0,1,2], k = 4
        输出：[2,0,1]*/
