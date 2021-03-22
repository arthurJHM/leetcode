package com.arthur.nowcoder;

/**
 * @title: NC78
 * @Author ArthurJi
 * @Date: 2021/3/22 14:31
 * @Version 1.0
 */
public class NC78 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Last = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return Last;
    }
}
