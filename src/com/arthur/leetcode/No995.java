package com.arthur.leetcode;

/**
 * @title: No995
 * @Author ArthurJi
 * @Date: 2021/2/18 12:26
 * @Version 1.0
 */
public class No995 {
    public static void main(String[] args) {
        System.out.println(new No995().minKBitFlips(new int[]{1, 1, 0}, 2));
    }

    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                for (int j = 0; j < K; j++) {
                    if((i + j) < A.length) {
                        A[i + j] ^= 1;
                    } else {
                        return -1;
                    }
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
}
