package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 两个链表的第一个公共节点
 * @title: JZoffer52
 * @Author hengmingji
 * @Date: 2021/12/28 12:34
 * @Version 1.0
 */
public class JZoffer52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa = headA;
        ListNode tempb = headB;
        while (tempa != tempb) {
            tempa = tempa == null ? headB : tempa.next;
            tempb = tempb == null ? headA : tempb.next;
        }
        return tempa;
    }
}
