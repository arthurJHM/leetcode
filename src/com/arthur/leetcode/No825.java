package com.arthur.leetcode;

import sun.management.Agent;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 适龄的朋友
 * @title: No825
 * @Author hengmingji
 * @Date: 2021/12/27 13:09
 * @Version 1.0
 */
public class No825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int len = ages.length;
        for (int i = 0, j = 0, k = 0; k < len; k++) {
            while (i < k && !check(ages[i], ages[k])) {
                i++;
            }
            if(j < k) {
                j = k;
            }
            while (j < len && check(ages[j], ages[k])) {
                j++;
            }
            if (j > i) {
                ans += j - i - 1;
            }
        }
        return ans;
    }

    private boolean check(int y, int x) {
        if (y <= 0.5 * x + 7) {
            return false;
        }
        if (y > x) {
            return false;
        }
        if (y > 100 && x < 100) {
            return false;
        }
        return true;
    }
}
