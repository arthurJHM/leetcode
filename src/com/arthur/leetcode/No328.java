package com.arthur.leetcode;

import jdk.nashorn.internal.objects.NativeNumber;
import org.w3c.dom.ls.LSInput;

import java.awt.*;
import java.util.List;

/**
 * @title: No328
 * @Author ArthurJi
 * @Date: 2021/4/8 13:34
 * @Version 1.0
 */
public class No328 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        new No328().oddEvenList(listNode1);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
class ListNode {
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
/*328. 奇偶链表
        给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

        请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

        示例 1:

        输入: 1->2->3->4->5->NULL
        输出: 1->3->5->2->4->NULL
        示例 2:

        输入: 2->1->3->5->6->4->7->NULL
        输出: 2->3->6->7->1->5->4->NULL
        说明:

        应当保持奇数节点和偶数节点的相对顺序。
        链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。*/
