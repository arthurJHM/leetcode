package com.arthur.leetcode;

import java.util.List;

/**
 * @title: No82
 * @Author ArthurJi
 * @Date: 2021/3/25 9:27
 * @Version 1.0
 */
public class No82 {
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
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            if(head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}


/*
82. 删除排序链表中的重复元素 II
        存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

        返回同样按升序排列的结果链表。



        示例 1：


        输入：head = [1,2,3,3,4,4,5]
        输出：[1,2,5]
        示例 2：


        输入：head = [1,1,1,2,3]
        输出：[2,3]*/
/*基本思路
        几乎所有的链表题目，都具有相似的解题思路。

        建一个「虚拟头节点」dummy 以减少边界判断，往后的答案链表会接在 dummy 后面

        使用 tail 代表当前有效链表的结尾

        通过原输入的 head 指针进行链表扫描

        我们会确保「进入外层循环时 head 不会与上一节点相同」，因此插入时机：

        head 已经没有下一个节点，head 可以被插入

        head 有一下个节点，但是值与 head 不相同，head 可以被插入

        代码：


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            // 进入循环时，确保了 head 不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            // 如果 head 与下一节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
时间复杂度：O(n)O(n)
        空间复杂度：O(n)O(n)
        拓展
        如果问题变为「相同节点保留一个」，该如何实现？
        83. 删除排序链表中的重复元素


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode a = head, b = a.next;
        while (b != null) {
            if (a.val != b.val) {
                a.next = b;
                a = a.next;
            }
            b = b.next;
        }
        a.next = null;
        return dummy.next;
    }
}
最后


        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/tong-yong-shan-chu-zhong-fu-jie-dian-lia-od9g/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
