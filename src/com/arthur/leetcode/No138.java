package com.arthur.leetcode;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.util.HashMap;

/**
 * @title: No138
 * @Author ArthurJi
 * @Date: 2021/4/14 22:16
 * @Version 1.0
 */
public class No138 {
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(-1);
        Node index = newHead;
        Node headIndex = head;
        while (headIndex != null) {
            Node node = new Node(headIndex.val);
            map.put(headIndex, node);
            index.next = node;
            index = index.next;
            headIndex = headIndex.next;
        }

        headIndex = head;
        index = newHead.next;
        while (headIndex != null) {
            index.random = map.get(headIndex.random);
            index = index.next;
            headIndex = headIndex.next;
        }
        return newHead.next;
    }
}
/*
138. 复制带随机指针的链表
        给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

        构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

        例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

        返回复制链表的头节点。

        用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

        val：一个表示 Node.val 的整数。
        random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
        你的代码 只 接受原链表的头节点 head 作为传入参数。



        示例 1：



        输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
        示例 2：



        输入：head = [[1,1],[2,1]]
        输出：[[1,1],[2,1]]
        示例 3：



        输入：head = [[3,null],[3,0],[3,null]]
        输出：[[3,null],[3,0],[3,null]]
        示例 4：

        输入：head = []
        输出：[]
        解释：给定的链表为空（空指针），因此返回 null。
*/
/*
解题思路
        深度拷贝的标准操作在于使用一个map，将旧节点映射到对应的新节点

        第一次遍历时不管random，创建一个newhead开头的新链表，这很简单。

        然后再用it指针遍历旧链表，map[it]就随之遍历了新链表
        我们要将map[it]->random指向it->random对应的新节点
        即：
        map[it]->random = map[it->random];

        作者：qing-feng-fu-shan-gang-5
        链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/c-bi-zhi-qian-de-fu-zhi-wu-xiang-tu-huan-9bsc/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
