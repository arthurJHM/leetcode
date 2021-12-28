package com.arthur.leetcode;

import sun.plugin2.os.windows.FLASHWINFO;

/**
 * @program: leetcode
 * @description: 合并两个排序的链表
 * @title: JZoffer25
 * @Author hengmingji
 * @Date: 2021/12/28 12:29
 * @Version 1.0
 */
public class JZoffer25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        }
        if(l1 == null) {
            temp.next = l2;
        }
        if(l2 == null) {
            temp.next = l1;
        }
        return head.next;
    }
}
