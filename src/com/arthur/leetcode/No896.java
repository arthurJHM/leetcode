package com.arthur.leetcode;

/**
 * @title: No896
 * @Author ArthurJi
 * @Date: 2021/2/28 13:51
 * @Version 1.0
 */
public class No896 {
    public static void main(String[] args) {

    }
    public boolean isMonotonic(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if(i == A.length - 1) {
                return true;
            }
            if(A[i + 1] - A[i] >= 0) {
                continue;
            }
            break;
        }
        for (int i = 0; i < A.length; i++) {
            if(i == A.length - 1) {
                return true;
            }
            if(A[i + 1] - A[i] <= 0) {
                continue;
            }
            break;
        }
        return false;
    }
}
