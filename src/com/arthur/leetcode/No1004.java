package com.arthur.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @title: No1004
 * @Author ArthurJi
 * @Date: 2021/2/19 0:01
 * @Version 1.0
 */
public class No1004 {
    public static void main(String[] args) {
        System.out.println(new No1004().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
    public int longestOnes(int[] A, int K) { // 自己写的，，，，错误解答
        int len = 0;
        int temp = 0;
        int before = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 1) {
                temp++;
            }
            else if(A[i] == 0 && K != 0) {
                temp++;
                K--;
                deque.add(i);
            }
            else if(A[i] == 0 && K == 0) {
                temp -= (deque.peek() - before);
                before = deque.removeFirst();
                deque.add(i);
            }
            len = Math.max(len, temp);
        }
        return len;
    }
}
