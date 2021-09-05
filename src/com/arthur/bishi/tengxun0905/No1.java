package com.arthur.bishi.tengxun0905;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/9/5 18:33
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solve(ListNode[] a) {
        ListNode dummy = new ListNode(-1);
        int N = a.length;
        ListNode[] curNode = new ListNode[N];
        for (int i = 0; i < N; i++) {
            curNode[i] = a[i];
        }
        ListNode p = dummy;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (curNode[i] != null) {
                    flag = true;
                    ListNode node = new ListNode(curNode[i].val);
                    p.next = node;
                    p = node;
                    curNode[i] = curNode[i].next;
                } else {
                    curNode[i] = null;
                }
            }
            if (!flag) {
                break;
            }
        }
        return dummy.next;
    }
}
