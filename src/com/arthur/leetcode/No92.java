package com.arthur.leetcode;

import java.util.LinkedList;

/**
 * @title: No92
 * @Author ArthurJi
 * @Date: 2021/3/18 9:32
 * @Version 1.0
 */
public class No92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;
    private ListNode reverse(ListNode head, int right) {
        if(right == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverse(head.next, right - 1);
        head.next.next = head;
        head.next = successor;//再下一轮递归的时候，这里就变成了head.next.next  会重新赋值的
        return last;
    }
}

/*
92. 反转链表 II
        反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

        说明:
        1 ≤ m ≤ n ≤ 链表长度。

        示例:

        输入: 1->2->3->4->5->NULL, m = 2, n = 4
        输出: 1->4->3->2->5->NULL
*/
