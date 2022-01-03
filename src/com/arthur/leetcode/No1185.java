package com.arthur.leetcode;

/**
 * @program: leetcode
 * @description: 一周中的第几天
 * @title: No1185
 * @Author hengmingji
 * @Date: 2022/1/3 14:52
 * @Version 1.0
 */
public class No1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] ss = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days = 4;
        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                days += 366;
            } else {
                days += 365;
            }
        }
        for (int i = 0; i < month - 1; i++) {
            days += monthDay[i];
        }
        if (month > 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            days++;
        }
        days+=day;
        return ss[days % 7];
    }
}
