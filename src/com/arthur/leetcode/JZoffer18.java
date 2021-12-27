package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 删除链表的节点
 * @title: JZoffer18
 * @Author hengmingji
 * @Date: 2021/12/27 13:46
 * @Version 1.0
 */
public class JZoffer18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                break;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}
