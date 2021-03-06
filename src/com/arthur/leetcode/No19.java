package com.arthur.leetcode;

/**
 * @title: No19
 * @Author ArthurJi
 * @Date: 2021/3/6 10:43
 * @Version 1.0
 */
public class No19 {

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
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head); //使用一个假头节点很棒
        ListNode fast = head;
        ListNode slow = dummy; //将慢指针设为dummy也很棒。如果设为head的话，好像还需要另外一个pre指针来指向前一个节点，
        for (int i = 0; i < n; i++) {
            if(fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
//        现在fast和slow的差(fast - solw + 1)是n+1
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
/*
19. 删除链表的倒数第 N 个结点
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

        进阶：你能尝试使用一趟扫描实现吗？



        示例 1：


        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        示例 2：

        输入：head = [1], n = 1
        输出：[]
        示例 3：

        输入：head = [1,2], n = 1
        输出：[1]*/
/*
方法三：双指针
        思路与算法

        我们也可以在不预处理出链表的长度，以及使用常数空间的前提下解决本题。

        由于我们需要找到倒数第 nn 个节点，因此我们可以使用两个指针 \textit{first}first 和 \textit{second}second 同时对链表进行遍历，并且 \textit{first}first 比 \textit{second}second 超前 nn 个节点。当 \textit{first}first 遍历到链表的末尾时，\textit{second}second 就恰好处于倒数第 nn 个节点。

        具体地，初始时 \textit{first}first 和 \textit{second}second 均指向头节点。我们首先使用 \textit{first}first 对链表进行遍历，遍历的次数为 nn。此时，\textit{first}first 和 \textit{second}second 之间间隔了 n-1n−1 个节点，即 \textit{first}first 比 \textit{second}second 超前了 nn 个节点。

        在这之后，我们同时使用 \textit{first}first 和 \textit{second}second 对链表进行遍历。当 \textit{first}first 遍历到链表的末尾（即 \textit{first}first 为空指针）时，\textit{second}second 恰好指向倒数第 nn 个节点。

        根据方法一和方法二，如果我们能够得到的是倒数第 nn 个节点的前驱节点而不是倒数第 nn 个节点的话，删除操作会更加方便。因此我们可以考虑在初始时将 \textit{second}second 指向哑节点，其余的操作步骤不变。这样一来，当 \textit{first}first 遍历到链表的末尾时，\textit{second}second 的下一个节点就是我们需要删除的节点。



        代码

        C++JavaPython3GolangC

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
