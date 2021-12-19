package com.arthur.leetcode;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 从尾到头打印链表
 * @title: JZoffer6
 * @Author hengmingji
 * @Date: 2021/12/18 15:37
 * @Version 1.0
 */
public class JZoffer6 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        reverse(list, head);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void reverse(ArrayList<Integer> list, ListNode head) {
        if(head == null) {
            return;
        }
        reverse(list, head.next);
        list.add(head.val);
    }

}
