package com.arthur.leetcode;

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
}
