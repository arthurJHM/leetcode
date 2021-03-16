package com.arthur.leetcode;

/**
 * @title: No1669
 * @Author ArthurJi
 * @Date: 2021/3/16 10:04
 * @Version 1.0
 */
public class No1669 {

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


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list1left = list1;
        ListNode list1right = list1;
        ListNode list2left = list2;

        int n = 0;
        while (n++ < a - 1) {
            list1left = list1left.next;
            list1right = list1right.next;
        }
        n--;
        while (n++ < b + 1) {
            list1right = list1right.next;
        }

        while (list2left.next != null) {
            list2left = list2left.next;
        }

        list1left.next = list2;
        list2left.next = list1right;

        return list1;
    }
}
/*
1669. 合并两个链表
        给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。

        请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。

        下图中蓝色边和节点展示了操作后的结果：


        请你返回结果链表的头指针。



        示例 1：



        输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
        输出：[0,1,2,1000000,1000001,1000002,5]
        解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
        示例 2：


        输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
        输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
        解释：上图中蓝色的边和节点为答案链表。*/
