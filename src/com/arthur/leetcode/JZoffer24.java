package com.arthur.leetcode;

import java.util.List;

/**
 * @program: leetcode
 * @description: 反转链表
 * @title: JZoffer24
 * @Author hengmingji
 * @Date: 2021/12/18 15:47
 * @Version 1.0
 */
public class JZoffer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if(cur == null) {
            return pre;
        }
        ListNode head = reverse(cur.next, cur);
        cur.next = pre;
        return head;
    }
}
