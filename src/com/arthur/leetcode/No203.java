package com.arthur.leetcode;

import java.util.LinkedList;
import java.util.jar.JarEntry;

/**
 * @title: No203
 * @Author ArthurJi
 * @Date: 2021/3/19 9:38
 * @Version 1.0
 */
public class No203 {

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (pre.next != null) {
            if(pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}

/*203. 移除链表元素
        给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


        示例 1：


        输入：head = [1,2,6,3,4,5,6], val = 6
        输出：[1,2,3,4,5]
        示例 2：

        输入：head = [], val = 1
        输出：[]
        示例 3：

        输入：head = [7,7,7,7], val = 7
        输出：[]*/
