package com.arthur.leetcode;

import java.util.List;

/**
 * @title: No142
 * @Author ArthurJi
 * @Date: 2021/2/24 18:42
 * @Version 1.0
 */


public class No142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        fast = head;
        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }
}
/*
方法二：快慢指针
       算法流程：
双指针第一次相遇： 设两指针 fast，slow 指向链表头部 head，fast 每轮走 22 步，slow 每轮走 11 步；

第一种结果： fast 指针走过链表末端，说明链表无环，直接返回 null；

TIPS: 若有环，两指针一定会相遇。因为每走 11 轮，fast 与 slow 的间距 +1+1，fast 终会追上 slow；
第二种结果： 当fast == slow时， 两指针在环中 第一次相遇 。下面分析此时fast 与 slow走过的 步数关系 ：

设链表共有 a+ba+b 个节点，其中 链表头部到链表入口 有 aa 个节点（不计链表入口节点）， 链表环 有 bb 个节点（这里需要注意，aa 和 bb 是未知数，例如图解上链表 a=4a=4 , b=5b=5）；设两指针分别走了 ff，ss 步，则有：
fast 走的步数是slow步数的 22 倍，即 f = 2sf=2s；（解析： fast 每轮走 22 步）
fast 比 slow多走了 nn 个环的长度，即 f = s + nbf=s+nb；（ 解析： 双指针都走过 aa 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）；
以上两式相减得：f = 2nbf=2nb，s = nbs=nb，即fast和slow 指针分别走了 2n2n，nn 个 环的周长 （注意： nn 是未知数，不同链表的情况不同）。
目前情况分析：

如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb（先走 aa 步到入口节点，之后每绕 11 圈环（ bb 步）都会再次到入口节点）。
而目前，slow 指针走过的步数为 nbnb 步。因此，我们只要想办法让 slow 再走 aa 步停下来，就可以到环的入口。
但是我们不知道 aa 的值，该怎么办？依然是使用双指针法。我们构建一个指针，此指针需要有以下性质：此指针和slow 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 aa 步？答案是链表头部head。
双指针第二次相遇：

slow指针 位置不变 ，将fast指针重新 指向链表头部节点 ；slow和fast同时每轮向前走 11 步；
TIPS：此时 f = 0f=0，s = nbs=nb ；
当 fast 指针走到f = af=a 步时，slow 指针走到步s = a+nbs=a+nb，此时 两指针重合，并同时指向链表环入口 。
返回slow指针指向的节点。

复杂度分析：
时间复杂度 O(N)O(N) ：第二次相遇中，慢指针须走步数 a < a + ba<a+b；第一次相遇中，慢指针须走步数 a + b - x < a + ba+b−x<a+b，其中 xx 为双指针重合点与环入口距离；因此总体为线性复杂度；
空间复杂度 O(1)O(1) ：双指针使用常数大小的额外空间。

1 / 11

代码：
PythonJava

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

作者：jyd
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
