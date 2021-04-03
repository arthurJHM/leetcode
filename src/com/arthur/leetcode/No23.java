package com.arthur.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @title: No23
 * @Author ArthurJi
 * @Date: 2021/4/3 17:18
 * @Version 1.0
 */
public class No23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> stack = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                stack.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!stack.isEmpty()) {
            temp.next = stack.poll();
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
/*
23. 合并K个升序链表
        给你一个链表数组，每个链表都已经按升序排列。

        请你将所有链表合并到一个升序链表中，返回合并后的链表。



        示例 1：

        输入：lists = [[1,4,5],[1,3,4],[2,6]]
        输出：[1,1,2,3,4,4,5,6]
        解释：链表数组如下：
        [
        1->4->5,
        1->3->4,
        2->6
        ]
        将它们合并到一个有序链表中得到。
        1->1->2->3->4->4->5->6
        示例 2：

        输入：lists = []
        输出：[]
        示例 3：

        输入：lists = [[]]
        输出：[]*/

