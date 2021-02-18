package com.arthur.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @title: No995
 * @Author ArthurJi
 * @Date: 2021/2/18 12:26
 * @Version 1.0
 */
public class No995 {
    public static void main(String[] args) {
        System.out.println(new No995().minKBitFlips1(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }

    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            if(A[i] == 0) {
                for (int j = 0; j < K; j++) {
                    A[i + j] ^= 1;
                }
                ans++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                return -1;
            }
        }
        return ans;
    }

    public int minKBitFlips1(int[] A, int K) {
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if(!deque.isEmpty() && deque.peek() + K - 1 < i) {
                deque.removeFirst();
            }

            //1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            //2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if(deque.size() % 2 == A[i]) {
                if(i + K > A.length) {
                    return -1;
                }
                deque.add(i);
                ans++;
            }
        }
        return ans;
    }
}
