package com.arthur.leetcode;

/**
 * @title: No1482
 * @Author ArthurJi
 * @Date: 2021/5/9 13:28
 * @Version 1.0
 */
public class No1482 {
    public static void main(String[] args) {
//        new No1482().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3);
        new No1482().minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2);
    }

    private int m;
    private int k;

    public int minDays(int[] bloomDay, int m_, int k_) {
        this.m = m_;
        this.k = k_;
        int left = 0;
        int right = Integer.MAX_VALUE;
        if (m * k > bloomDay.length) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, bloomDay)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int mid, int[] bloomDay) {
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (mid >= bloomDay[i]) {
//                ans++;
                cur++;
//                i++;
                while (cur < k && i + 1 < bloomDay.length && mid >= bloomDay[i + 1]) {
                    i++;
                    cur++;
                }
                if (cur == k) {
                    ans++;
                }
                cur = 0;
            }
        }
        return ans >= m;
    }
}
