package com.arthur.leetcode;

/**
 * @title: No83
 * @Author ArthurJi
 * @Date: 2021/3/16 10:18
 * @Version 1.0
 */
public class No83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null) {
            if(node.next.val == node.val) {
                node.next = node.next.next;
//                node = node.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
/*83. 删除排序链表中的重复元素
        给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

        示例 1:

        输入: 1->1->2
        输出: 1->2
        示例 2:

        输入: 1->1->2->3->3
        输出: 1->2->3*/
