package com.arthur.bishi.tengxun0822;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/8/22 20:23
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode[] solve (int m, ListNode a) {
        // write code here
        ArrayList<ListNode> arrayLists[] = new ArrayList[m];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<ListNode>();
        }
        while (a != null) {
            arrayLists[a.val % m].add(a);
            a = a.next;
        }
        for (ArrayList<ListNode> arrayList : arrayLists) {
            arrayList.sort(((o1, o2) -> {
                return o2.val - o1.val;
            }));
        }
        ListNode[] ans = new ListNode[m];
        ListNode pre = null;
        for (int i = 0; i < arrayLists.length; i++) {
            for (ListNode listNode : arrayLists[i]) {
                listNode.next = pre;
                pre = listNode;
            }
            ans[i] = pre;
            pre = null;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(11);
        ListNode listNode6 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        new No1().solve(5, listNode);
    }
}
