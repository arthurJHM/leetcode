package com.arthur.bishi.tengxun0722;

/**
 * @description：
 * @author： arthurji
 * @date： 2021/7/22 20:10
 * @modifiedBy：
 * @version: 1.0
 */
public class No1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node2);

    }
    public static Node reverse(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class Node {
    Node next;
    Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


