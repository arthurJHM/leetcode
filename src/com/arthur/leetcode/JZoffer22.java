package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 链表中倒数第k个节点
 * @title: JZoffer22
 * @Author hengmingji
 * @Date: 2021/12/27 13:57
 * @Version 1.0
 */
public class JZoffer22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
