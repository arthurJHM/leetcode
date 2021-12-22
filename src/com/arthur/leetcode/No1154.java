package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 一年中的第几天
 * @title: No1154
 * @Author hengmingji
 * @Date: 2021/12/21 13:30
 * @Version 1.0
 */
public class No1154 {
    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0,4));
        int month = Integer.valueOf(date.substring(5,7));
        int day = Integer.valueOf(date.substring(8,10));
        int[] days;
        if(check(year)) {
            days = new int[]{31,29,31,30,31,30,31,31,30,31,30};
        } else {
            days = new int[]{31,28,31,30,31,30,31,31,30,31,30};
        }
        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += days[i];
        }
        ans += day;
        return ans;
    }

    private boolean check(int year) {
        if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
