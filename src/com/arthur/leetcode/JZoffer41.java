package com.arthur.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 数据流中的中位数
 * @title: JZoffer41
 * @Author hengmingji
 * @Date: 2022/1/2 17:43
 * @Version 1.0
 */
public class JZoffer41 {
    Queue<Integer> a;
    Queue<Integer> b;

    /**
     * initialize your data structure here.
     */
    public JZoffer41() {
        a = new PriorityQueue<>();
        b = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    }

    public void addNum(int num) {
        if (a.size() == b.size()) {
            a.add(num);
            b.add(a.poll());
        } else {
            b.add(num);
            a.add(b.poll());
        }
    }

    public double findMedian() {
        if (a.size() == b.size()) {
            return (double) (a.peek() + b.peek()) / 2;
        } else {
            return (double) b.peek();
        }
    }

    public static void main(String[] args) {
        JZoffer41 jZoffer41 = new JZoffer41();
        jZoffer41.addNum(1);
        System.out.println(jZoffer41.findMedian());
    }
}
