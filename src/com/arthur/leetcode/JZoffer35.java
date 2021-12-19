package com.arthur.leetcode;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 复杂链表的复制
 * @title: JZoffer35
 * @Author hengmingji
 * @Date: 2021/12/18 16:38
 * @Version 1.0
 */

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

public class JZoffer35 {
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
