package com.arthur.leetcode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 供暖器
 * @title: No475
 * @Author hengmingji
 * @Date: 2021/12/20 13:22
 * @Version 1.0
 */
public class No475 {
    public int findRadius(int[] houses, int[] heaters) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < heaters.length; j++) {
                min = Math.min(min, Math.abs(heaters[j] - houses[i]));
            }
            max = Math.max(min, max);
            min = Integer.MAX_VALUE;
        }
        return max;
    }

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Integer.MAX_VALUE;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(houses, heaters, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] houses, int[] heaters, int x) {
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j < heaters.length && houses[i] - x > heaters[j]) {
                j++;
            }
            if(j < heaters.length && houses[i] + x >= heaters[j] && houses[i] - x <= heaters[j]) {
                continue;
            }
            return false;
        }
        return true;
    }
}
